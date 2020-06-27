package kimchi.logger.android

import kimchi.logger.CompositeLogWriter
import kimchi.logger.ConsolidatedLogger
import kimchi.logger.MutableLogWriters
import kimchi.logger.ThresholdWriter

/*
 * This code is roughly based on code from Jake Wharton's Timber library.
 * sources received from: https://github.com/JakeWharton/timber
 * Copyright Jake Wharton and licensed under:
 * Apache License Version 2.0, January 2004
 * http://www.apache.org/licenses/
 * Modifications:
 *  - Converted to Kotlin.
 *  - Filtered out anonymous classes instead of offsetting.
 *  - Re-written to exclude default implementations.
 *  - Added base offset to shift tag locations.
 */

/**
 * Locate Log Tags by the name of the class that logged it.
 */
internal object Tags {
    private const val MAX_TAG_LENGTH = 23
    private val ANONYMOUS_CLASS = Regex("\\$.+")
    private val DEFAULT_METHOD = Regex("\\\$DefaultImpls\$")
    private val INTERNAL: List<String> = listOf(
            Tags::class.java,
            AdbWriter::class.java,
            CompositeLogWriter::class.java,
            ConsolidatedLogger::class.java,
            MutableLogWriters::class.java,
            ThresholdWriter::class.java
        )
        .map { it.name }

    fun getStackTag(blacklist: List<String> = emptyList()): String {
        val stackTrace = Throwable().stackTrace
        val element = stackTrace
                .also { it.forEach { println("before: $it") } }
            .filter { !it.className.contains(DEFAULT_METHOD) }
            .filter { it.className !in INTERNAL }
            .filter { it.className != "kimchi.Kimchi" }
                .also { it.forEach { println("after: $it") } }
            .firstOrNull { it.className !in blacklist }
        val className = element?.className ?: return "unknown"
        val simpleName = if (className.contains('$')) {
            className.substring(className.lastIndexOf('.') + 1, className.indexOf('$'))
        } else {
            className.substring(className.lastIndexOf('.') + 1)
        }

        return if (simpleName.length > MAX_TAG_LENGTH) simpleName.substring(0, MAX_TAG_LENGTH) else simpleName
    }
}

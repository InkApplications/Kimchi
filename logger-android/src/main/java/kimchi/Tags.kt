package kimchi
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
    private const val CALL_STACK_INDEX = 2
    private val ANONYMOUS_CLASS = Regex("(\\$\\d+)+$")
    private val DEFAULT_METHOD = Regex("\\\$DefaultImpls\$")
    private val INTERNAL: List<String> = listOf(
            Tags::class.java,
            AdbWriter::class.java,
            Kimchi::class.java,
            CompositeLogWriter::class.java,
            ConsolidatedLogger::class.java,
            StatefulWriter::class.java,
            ThresholdWriter::class.java
        )
        .map { it.name }

    fun getStackTag(blacklist: List<String> = emptyList()): String {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size <= CALL_STACK_INDEX) {
            return "Unknown"
        }
        val element = stackTrace
            .filter { !it.className.contains(ANONYMOUS_CLASS) }
            .filter { !it.className.contains(DEFAULT_METHOD) }
            .filter { it.className !in INTERNAL }
            .first { it.className !in blacklist }
        val className = element.className
        val simpleName = className.substring(className.lastIndexOf('.') + 1)

        return if (simpleName.length > MAX_TAG_LENGTH) simpleName.substring(0, MAX_TAG_LENGTH) else simpleName
    }
}

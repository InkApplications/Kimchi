package kimchi

import kimchi.logger.ConsolidatedLogger
import kimchi.logger.KimchiLogger
import kimchi.logger.LogWriter
import kimchi.logger.MutableLogWriters

/**
 * Static Logging Facade.
 *
 * A simple static object for accessing Kimchi's logging methods.
 *
 * By Default, logs will do nothing. Add a logger with the [add] method
 * before using:
 *
 *     Kimchi.add(StandardWriter)
 *     Kimchi.info("Logs now go to Std Out!")
 */
object Kimchi: KimchiLogger {
    private val writer = MutableLogWriters()
    private val logger = ConsolidatedLogger(writer)

    /**
     * Add a writer to the collection.
     */
    fun add(writer: LogWriter) = this.writer.add(writer)

    /**
     * Remove a writer from the collection.
     */
    fun remove(writer: LogWriter) = this.writer.remove(writer)

    /**
     * Clear all writers from the collection.
     */
    fun clear() = this.writer.clear()

    override fun trace(message: String, cause: Throwable?) = logger.trace(message, cause)
    override fun trace(cause: Throwable?, message: () -> String) = logger.trace(cause, message)
    override fun debug(message: String, cause: Throwable?) = logger.debug(message, cause)
    override fun debug(cause: Throwable?, message: () -> String) = logger.debug(cause, message)
    override fun info(message: String, cause: Throwable?) = logger.info(message, cause)
    override fun info(cause: Throwable?, message: () -> String) = logger.info(cause, message)
    override fun warn(message: String, cause: Throwable?) = logger.warn(message, cause)
    override fun warn(cause: Throwable?, message: () -> String) = logger.warn(cause, message)
    override fun error(message: String, cause: Throwable?) = logger.error(message, cause)
    override fun error(cause: Throwable?, message: () -> String) = logger.error(cause, message)
}

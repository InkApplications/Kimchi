package kimchi

/**
 * Combine several writers into a single writer.
 *
 * This queries all writers' `shouldLog` methods to determine if a log should
 * be performed, and filters out any loggers that should not be logged to.
 *
 * @param writers Writers to be invoked with each log call.
 */
class CompositeLogWriter(
    val writers: Set<LogWriter>
): LogWriter {
    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean {
        return writers.any { it.shouldLog(level, cause) }
    }

    override fun log(level: LogLevel, message: String, cause: Throwable?) {
        writers.filter { it.shouldLog(level, cause) }.forEach {
            it.log(level, message, cause)
        }
    }
}

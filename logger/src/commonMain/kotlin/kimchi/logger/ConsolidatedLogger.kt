package kimchi.logger

/**
 * Fulfils the logger contract by sending logs to a writer.
 *
 * This will check that the writer is enabled for each given log call and
 * consolidate it into the writer's single `log` method using the log levels.
 *
 * @param writer The writer to receive the logs.
 */
class ConsolidatedLogger(
    private val writer: LogWriter
): KimchiLogger {
    override fun trace(message: String, cause: Throwable?) = logIfApplicable(LogLevel.TRACE, message, cause)
    override fun trace(cause: Throwable?, message: () -> String) = logIfApplicable(LogLevel.TRACE, message, cause)
    override fun debug(message: String, cause: Throwable?) = logIfApplicable(LogLevel.DEBUG, message, cause)
    override fun debug(cause: Throwable?, message: () -> String) = logIfApplicable(LogLevel.DEBUG, message, cause)
    override fun info(message: String, cause: Throwable?) = logIfApplicable(LogLevel.INFO, message, cause)
    override fun info(cause: Throwable?, message: () -> String) = logIfApplicable(LogLevel.INFO, message, cause)
    override fun warn(message: String, cause: Throwable?) = logIfApplicable(LogLevel.WARNING, message, cause)
    override fun warn(cause: Throwable?, message: () -> String) = logIfApplicable(LogLevel.WARNING, message, cause)
    override fun error(message: String, cause: Throwable?) = logIfApplicable(LogLevel.ERROR, message, cause)
    override fun error(cause: Throwable?, message: () -> String) = logIfApplicable(LogLevel.ERROR, message, cause)

    /**
     * Invoke the writer's log method only if enabled for the log type.
     */
    private fun logIfApplicable(level: LogLevel, message: String, cause: Throwable?) {
        if (writer.shouldLog(level)) {
            writer.log(level, message, cause)
        }
    }

    /**
     * Invoke the writer's log method only if enabled for the log type.
     */
    private fun logIfApplicable(level: LogLevel, message: () -> String, cause: Throwable?) {
        if (writer.shouldLog(level)) {
            writer.log(level, message(), cause)
        }
    }
}

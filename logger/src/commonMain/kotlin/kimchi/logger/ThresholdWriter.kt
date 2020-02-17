package kimchi.logger

/**
 * Implements a conditional logger by the most common condition of Log Levels.
 *
 * This maintains the delegated logger's `shouldLog` value! Both loggers must
 * be enabled for the log to be written.
 *
 * @param threshold The severity at which logs will start being written.
 * @param writer The writer that will perform the log.
 */
class ThresholdWriter(
    private val threshold: LogLevel,
    private val writer: LogWriter
): LogWriter {
    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean = writer.shouldLog(level, cause) && level >= threshold
    override fun log(level: LogLevel, message: String, cause: Throwable?) = writer.log(level, message, cause)
}

/**
 * Functional syntax for creating a logger with a threshold.
 *
 * Example:
 *
 *     StandardWriter.withThreshold(LogLevel.WARNING)
 *
 * @param threshold The severity at which logs will start being written.
 */
fun LogWriter.withThreshold(threshold: LogLevel) = ThresholdWriter(threshold, this)

package kimchi

/**
 * Write logs into a file, output, or service.
 *
 * This defines a class that is in charge of determining how and where to write
 * a given log line.
 */
interface LogWriter {
    /**
     * Determine if logs are enabled for a given log.
     *
     * This is used for performance optimization with lazy log messages
     * and can be used to filter out logs of a certain level in different
     * variants of the app such as debug/prod modes.
     *
     * @param level The severity of the log that will be written.
     * @param cause The cause of the log that will be written, if applicable.
     * @return whether this writer intends to write the log described.
     */
    fun shouldLog(level: LogLevel, cause: Throwable? = null): Boolean

    /**
     * Write a log to a file, output or service.
     *
     * If this method is invoked, it has already been determined that the log
     * should be written with [shouldLog].
     *
     * @param level The severity of the log to be written.
     * @param message The message to be logged.
     * @param cause The cause associated with the log, if applicable.
     */
    fun log(level: LogLevel, message: String, cause: Throwable? = null)
}

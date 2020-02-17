package kimchi.logger

/**
 * Do nothing logger.
 *
 * This might be useful for testing, or possibly ad a base delegate.
 */
object EmptyWriter: LogWriter {
    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean = false
    override fun log(level: LogLevel, message: String, cause: Throwable?) {}
}

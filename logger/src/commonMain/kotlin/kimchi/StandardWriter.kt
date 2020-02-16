package kimchi

/**
 * Write all logs to Standard I/O on the platform.
 */
object StandardWriter: LogWriter {
    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean = true
    override fun log(level: LogLevel, message: String, cause: Throwable?) {
        println("[$level]: $message")
    }
}

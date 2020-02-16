package kimchi

class WriterSpy(val write: Boolean = true): LogWriter {
    var log: Triple<LogLevel, String, Throwable?>? = null
    val logged: Boolean get() = log != null

    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean = write

    override fun log(level: LogLevel, message: String, cause: Throwable?) {
        log = Triple(level, message, cause)
    }
}

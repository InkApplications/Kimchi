package kimchi.logger

/**
 * A Logger that does nothing.
 *
 * This can be useful for testing or as a default delegate.
 */
object EmptyLogger: KimchiLogger {
    override fun trace(message: String, cause: Throwable?) = Unit
    override fun trace(cause: Throwable?, message: () -> String) = Unit
    override fun debug(message: String, cause: Throwable?) = Unit
    override fun debug(cause: Throwable?, message: () -> String) = Unit
    override fun info(message: String, cause: Throwable?) = Unit
    override fun info(cause: Throwable?, message: () -> String) = Unit
    override fun warn(message: String, cause: Throwable?) = Unit
    override fun warn(cause: Throwable?, message: () -> String) = Unit
    override fun error(message: String, cause: Throwable?) = Unit
    override fun error(cause: Throwable?, message: () -> String)  = Unit
}

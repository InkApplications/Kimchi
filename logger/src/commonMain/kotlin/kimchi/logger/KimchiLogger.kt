package kimchi.logger

/**
 * Main Logging Interface.
 *
 * This is the primary API for sending logs with Kimchi. It can be used directly
 * in place of the static facade to inject a logger, where applicable.
 *
 * This logging interface provides a simple and lazy method for each of the
 * logging levels. The lazy method may be used if the log contains an expensive
 * operation that should only be invoked if the logs are enabled.
 *
 * example of simple logging:
 *
 *     logger.trace("Simple Log")
 *
 * example of lazy logging:
 *
 *     logger.trace() { "This message is $expensive" }
 *
 * A Cause may be optionally associated with each log;
 *
 *     logger.warn("Something went wrong", exception)
 *     // or
 *     logger.warn(exception) { "Something went wrong" }
 */
interface KimchiLogger {
    fun trace(message: String, cause: Throwable? = null)
    fun trace(cause: Throwable? = null, message: () -> String)
    fun debug(message: String, cause: Throwable? = null)
    fun debug(cause: Throwable? = null, message: () -> String)
    fun info(message: String, cause: Throwable? = null)
    fun info(cause: Throwable? = null, message: () -> String)
    fun warn(message: String, cause: Throwable? = null)
    fun warn(cause: Throwable? = null, message: () -> String)
    fun error(message: String, cause: Throwable? = null)
    fun error(cause: Throwable? = null, message: () -> String)
}

package kimchi.logger.js

import kimchi.logger.LogLevel
import kimchi.logger.LogLevel.*
import kimchi.logger.LogWriter

/**
 * Send errors to the Javascript Console Output.
 */
object ConsoleWriter: LogWriter {
    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean = true
    override fun log(level: LogLevel, message: String, cause: Throwable?) {
        when (level) {
            TRACE, DEBUG -> console.log(message)
            INFO -> console.info(message)
            WARNING -> console.warn(message)
            ERROR -> console.error(message)
        }
        cause?.run(console::log)
    }
}

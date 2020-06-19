package kimchi.logger.android

import android.util.Log
import kimchi.logger.LogLevel.*
import kimchi.logger.android.Tags.getStackTag
import kimchi.logger.LogLevel
import kimchi.logger.LogWriter

/**
 * Send log messages to Android's ADB Logger.
 *
 * @param blacklist Classes to exclude from tags when writing logs. This can be
 *        used if the logger is wrapped in another class so that the tags can
 *        be retained despite being called indirectly.
 */
class AdbWriter(
    blacklist: List<Class<Any>> = emptyList()
): LogWriter {
    private val blacklistNames = blacklist.map { it.name }
    override fun log(level: LogLevel, message: String, cause: Throwable?) {
        when(level) {
            TRACE -> Log.v(getStackTag(blacklistNames), message, cause)
            DEBUG -> Log.d(getStackTag(blacklistNames), message, cause)
            INFO -> Log.i(getStackTag(blacklistNames), message, cause)
            WARNING -> Log.w(getStackTag(blacklistNames), message, cause)
            ERROR -> Log.e(getStackTag(blacklistNames), message, cause)
        }
    }
    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean = true
}

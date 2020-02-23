package kimchi

import kimchi.analytics.*
import kimchi.logger.*

/**
 * Static Logging and Analytics Facade.
 *
 * A simple static object for accessing Kimchi's logging and analytics methods.
 *
 * By Default, logs and analytics events will do nothing.
 *
 * Add a logger with the [addLog] method before using:
 *
 *     Kimchi.addLog(StandardWriter)
 *     Kimchi.info("Logs now go to Std Out!")
 *
 * Add an analytics service with the [addAnalytics] method before using:
 *
 *     Kimchi.addAnalytics(CrashlyticsWriter())
 *     Kimchi.trackEvent("App Start")
 */
object Kimchi: KimchiLogger, KimchiAnalytics {
    private val logWriters = MutableLogWriters()
    private val logger = ConsolidatedLogger(logWriters)
    private val analyticsWriters = MutableAnalyticsWriters()
    private val analytics = ConsolidatedAnalytics(analyticsWriters)

    /**
     * Add a writer to the collection.
     */
    fun addLog(writer: LogWriter) = logWriters.add(writer)

    /**
     * Remove a writer from the collection.
     */
    fun removeLog(writer: LogWriter) = logWriters.remove(writer)

    /**
     * Add a writer to the collection.
     */
    fun addAnalytics(writer: AnalyticsWriter) = analyticsWriters.add(writer)

    /**
     * Add a writer to the collection.
     */
    fun removeAnalytics(writer: AnalyticsWriter) = analyticsWriters.remove(writer)

    /**
     * Clear all writers from both Logs and Analytics.
     */
    fun clear() {
        logWriters.clear()
        analyticsWriters.clear()
    }

    override fun trace(message: String, cause: Throwable?) = logger.trace(message, cause)
    override fun trace(cause: Throwable?, message: () -> String) = logger.trace(cause, message)
    override fun debug(message: String, cause: Throwable?) = logger.debug(message, cause)
    override fun debug(cause: Throwable?, message: () -> String) = logger.debug(cause, message)
    override fun info(message: String, cause: Throwable?) = logger.info(message, cause)
    override fun info(cause: Throwable?, message: () -> String) = logger.info(cause, message)
    override fun warn(message: String, cause: Throwable?) = logger.warn(message, cause)
    override fun warn(cause: Throwable?, message: () -> String) = logger.warn(cause, message)
    override fun error(message: String, cause: Throwable?) = logger.error(message, cause)
    override fun error(cause: Throwable?, message: () -> String) = logger.error(cause, message)
    override fun setProperty(property: Property<Any>) = analytics.setProperty(property)
    override fun setProperties(properties: List<Property<Any>>) = analytics.setProperties(properties)
    override fun trackEvent(name: String, properties: List<Property<Any>>) = analytics.trackEvent(name, properties)
    override fun trackScreen(name: String, properties: List<Property<Any>>) = analytics.trackScreen(name, properties)
}

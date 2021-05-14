package kimchi

import kimchi.analytics.AnalyticsWriter
import kimchi.analytics.logger.LogAnalyticsWriter

/**
 * Sends Analytics events to the logger.
 *
 * Add this as an analytics writer if you want to see analytics events in logs.
 *
 * example:
 *
 *     Kimchi.addLog(StandardWriter)
 *     Kimchi.addAnalytics(KimchiLoggerAnalytics)
 *     Kimchi.event("Hello World")
 *
 * will show a log like:
 *
 *     [INFO]: Analytics Event: [Hello World]
 */
val KimchiLoggerAnalytics: AnalyticsWriter = LogAnalyticsWriter(Kimchi)

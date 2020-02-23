package kimchi.analytics.logger

import kimchi.analytics.AnalyticsWriter
import kimchi.analytics.Property
import kimchi.logger.KimchiLogger

/**
 * Sends analytics events to a logger.
 *
 * @param logger Logger to receive analytics events.
 */
class LogAnalyticsWriter(
    private val logger: KimchiLogger
): AnalyticsWriter {
    override fun writeProperties(properties: List<Property<Any>>) {
        logger.info("Analytics Properties Set: $properties")
    }

    override fun writeEvent(name: String, properties: List<Property<Any>>) {
        if (properties.isNotEmpty()) {
            logger.info("Analytics Event: [$name] with properties: $properties")
        } else {
            logger.info("Analytics Event: [$name]")
        }
    }

    override fun writeScreen(name: String, properties: List<Property<Any>>) {
        if (properties.isNotEmpty()) {
            logger.info("Screen Track: [$name] with properties: $properties")
        } else {
            logger.info("Screen Track: [$name]")
        }
    }
}

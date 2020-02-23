package kimchi.analytics

/**
 * Combine many writers into a single writer.
 *
 * This dispatches the analytics events to all loggers in a set.
 *
 * @param writers Writers to receive the event.
 */
class CompositeAnalyticsWriter(
    val writers: Set<AnalyticsWriter>
): AnalyticsWriter {
    override fun writeProperties(properties: List<Property<Any>>) {
        writers.forEach { it.writeProperties(properties) }
    }

    override fun writeEvent(name: String, properties: List<Property<Any>>) {
        writers.forEach { it.writeEvent(name, properties) }
    }

    override fun writeScreen(name: String, properties: List<Property<Any>>) {
        writers.forEach { it.writeScreen(name, properties) }
    }
}


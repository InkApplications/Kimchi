package kimchi.analytics

/**
 * Fulfils the Analytics contract by sending events to a writer.
 *
 * @param writer The writer to receive events and properties.
 */
class ConsolidatedAnalytics(
    private val writer: AnalyticsWriter
): KimchiAnalytics {
    override fun setProperty(property: Property<Any>) {
        writer.writeProperties(listOf(property))
    }

    override fun setProperties(properties: List<Property<Any>>) {
        writer.writeProperties(properties)
    }

    override fun trackEvent(name: String, properties: List<Property<Any>>) {
        writer.writeEvent(name, properties)
    }

    override fun trackScreen(name: String, properties: List<Property<Any>>) {
        writer.writeScreen(name, properties)
    }
}

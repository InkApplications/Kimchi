package kimchi.analytics

class WriterSpy: AnalyticsWriter {
    var properties: List<Property<Any>>? = null
    var event: Pair<String, List<Property<Any>>>? = null
    var screen: Pair<String, List<Property<Any>>>? = null

    override fun writeProperties(properties: List<Property<Any>>) {
        this.properties = properties
    }

    override fun writeEvent(name: String, properties: List<Property<Any>>) {
        this.event = name to properties
    }

    override fun writeScreen(name: String, properties: List<Property<Any>>) {
        this.screen = name to properties
    }
}

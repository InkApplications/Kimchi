package kimchi.analytics

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate

class MutableAnalyticsWriters: AnalyticsWriter {
    private val delegate = MutableStateFlow<CompositeAnalyticsWriter?>(null)

    override fun writeProperties(properties: List<Property<Any>>) {
        delegate.value?.writeProperties(properties)
    }

    override fun writeEvent(name: String, properties: List<Property<Any>>) {
        delegate.value?.writeEvent(name, properties)
    }

    override fun writeScreen(name: String, properties: List<Property<Any>>) {
        delegate.value?.writeScreen(name, properties)
    }

    fun add(writer: AnalyticsWriter) {
        delegate.getAndUpdate {
            CompositeAnalyticsWriter(it?.writers.orEmpty() + writer)
        }
    }

    fun remove(writer: AnalyticsWriter) {
        delegate.getAndUpdate {
            CompositeAnalyticsWriter(it?.writers.orEmpty() - writer)
        }
    }

    fun clear() {
        delegate.value = null
    }
}

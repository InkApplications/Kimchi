package kimchi.logger

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate

/**
 * Delegate to a collection of loggers that can be modified.
 */
class MutableLogWriters: LogWriter {
    private val delegate = MutableStateFlow<CompositeLogWriter?>(null)

    override fun shouldLog(level: LogLevel, cause: Throwable?): Boolean {
        return delegate.value?.shouldLog(level, cause) ?: false
    }

    override fun log(level: LogLevel, message: String, cause: Throwable?) {
        delegate.value?.log(level, message, cause)
    }

    /**
     * Add a writer to the delegated collection.
     */
    fun add(writer: LogWriter) {
        delegate.getAndUpdate {
            CompositeLogWriter(it?.writers.orEmpty() + writer)
        }
    }

    /**
     * Remove a writer from the delegated collection.
     */
    fun remove(writer: LogWriter) {
        delegate.getAndUpdate {
            CompositeLogWriter(it?.writers.orEmpty() - writer)
        }
    }

    /**
     * Clear all loggers from the delegated collection.
     */
    fun clear() {
        delegate.value = null
    }
}

package kimchi.analytics.logger

import kimchi.analytics.stringProperty
import kimchi.logger.KimchiLogger
import kotlin.test.Test
import kotlin.test.assertEquals

class LogAnalyticsWriterTest {
    @Test
    fun propertyLogs() {
        val spy = LoggerSpy()
        val writer = LogAnalyticsWriter(spy)
        val properties = listOf(stringProperty("Test", "string"))

        writer.writeProperties(properties)

        assertEquals("Analytics Properties Set: [StringProperty(key=Test, value=string)]", spy.message)
    }

    @Test
    fun eventWithProperties() {
        val spy = LoggerSpy()
        val writer = LogAnalyticsWriter(spy)
        val properties = listOf(stringProperty("Test", "string"))

        writer.writeEvent("event", properties)

        assertEquals("Analytics Event: [event] with properties: [StringProperty(key=Test, value=string)]", spy.message)
    }

    @Test
    fun plainEvent() {
        val spy = LoggerSpy()
        val writer = LogAnalyticsWriter(spy)

        writer.writeEvent("event", emptyList())

        assertEquals("Analytics Event: [event]", spy.message)
    }

    @Test
    fun screenWithProperties() {
        val spy = LoggerSpy()
        val writer = LogAnalyticsWriter(spy)
        val properties = listOf(stringProperty("Test", "string"))

        writer.writeScreen("screen", properties)

        assertEquals("Screen Track: [screen] with properties: [StringProperty(key=Test, value=string)]", spy.message)
    }

    @Test
    fun plainScreen() {
        val spy = LoggerSpy()
        val writer = LogAnalyticsWriter(spy)

        writer.writeScreen("screen", emptyList())

        assertEquals("Screen Track: [screen]", spy.message)
    }
}

class LoggerSpy: KimchiLogger {
    var message: String? = null
    override fun info(message: String, cause: Throwable?) {
        this.message = message
    }

    override fun trace(message: String, cause: Throwable?) = TODO("not implemented")
    override fun trace(cause: Throwable?, message: () -> String) = TODO("not implemented")
    override fun debug(message: String, cause: Throwable?) = TODO("not implemented")
    override fun debug(cause: Throwable?, message: () -> String) = TODO("not implemented")
    override fun info(cause: Throwable?, message: () -> String) = TODO("not implemented")
    override fun warn(message: String, cause: Throwable?) = TODO("not implemented")
    override fun warn(cause: Throwable?, message: () -> String) = TODO("not implemented")
    override fun error(message: String, cause: Throwable?) = TODO("not implemented")
    override fun error(cause: Throwable?, message: () -> String) = TODO("not implemented")
}

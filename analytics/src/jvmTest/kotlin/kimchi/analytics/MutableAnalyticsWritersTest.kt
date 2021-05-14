package kimchi.analytics

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class MutableAnalyticsWritersTest {
    @Test
    fun noWriters() {
        val writer = MutableAnalyticsWriters()
        val properties = listOf(stringProperty("Test", "string"))

        writer.writeProperties(properties)
        writer.writeEvent("event", properties)
        writer.writeScreen("screen", properties)
    }

    @Test
    fun addWriter() {
        val spy = WriterSpy()
        val properties = listOf(stringProperty("Test", "string"))
        val writer = MutableAnalyticsWriters()

        writer.add(spy)
        writer.writeProperties(properties)
        writer.writeEvent("event", properties)
        writer.writeScreen("screen", properties)

        assertNotNull(spy.screen, "Added writer should receive screens.")
        assertNotNull(spy.event, "Added writer should receive events.")
        assertNotNull(spy.properties, "Added writer should receive properties.")
    }

    @Test
    fun removeWriter() {
        val spy = WriterSpy()
        val properties = listOf(stringProperty("Test", "string"))
        val writer = MutableAnalyticsWriters()

        writer.add(spy)
        writer.remove(spy)
        writer.writeProperties(properties)
        writer.writeEvent("event", properties)
        writer.writeScreen("screen", properties)

        assertNull(spy.screen, "Removed writer should not receive screens.")
        assertNull(spy.event, "Removed writer should not receive events.")
        assertNull(spy.properties, "Removed writer should not receive properties.")
    }

    @Test
    fun clear() {
        val spy = WriterSpy()
        val properties = listOf(stringProperty("Test", "string"))
        val writer = MutableAnalyticsWriters()

        writer.add(spy)
        writer.clear()
        writer.writeProperties(properties)
        writer.writeEvent("event", properties)
        writer.writeScreen("screen", properties)

        assertNull(spy.screen, "Cleared writers should not receive screens.")
        assertNull(spy.event, "Cleared writers should not receive events.")
        assertNull(spy.properties, "Cleared writers should not receive properties.")
    }
}

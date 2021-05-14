package kimchi.analytics

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class ConsolidatedAnalyticsTest {
    @Test
    fun proxies() {
        val spy = WriterSpy()
        val analytics = ConsolidatedAnalytics(spy)
        val properties = listOf(stringProperty("Test", "string"))

        analytics.setProperties(properties)
        assertSame(properties, spy.properties, "Properties should be proxied directly")

        analytics.trackScreen("screen", properties)
        assertEquals("screen" to properties, spy.screen, "Screen Should be proxied directly")

        analytics.trackEvent("event", properties)
        assertEquals("event" to properties, spy.event, "Event Should be proxied directly")
    }

    @Test
    fun singleProperty() {
        val spy = WriterSpy()
        val analytics = ConsolidatedAnalytics(spy)
        val property = stringProperty("Test", "string")

        analytics.setProperty(property)

        assertEquals(listOf(property), spy.properties, "Single Property should be written as list.")
    }
}

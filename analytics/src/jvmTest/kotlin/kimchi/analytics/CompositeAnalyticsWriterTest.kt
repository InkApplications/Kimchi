package kimchi.analytics

import kotlin.test.Test
import kotlin.test.assertNull
import kotlin.test.assertNotNull

class CompositeAnalyticsWriterTest {
    @Test
    fun testReceiveScreen() {
        val firstSpy = WriterSpy()
        val secondSpy = WriterSpy()
        val writer = CompositeAnalyticsWriter(setOf(firstSpy, secondSpy))

        writer.writeScreen("Test", emptyList())

        assertNotNull(firstSpy.screen, "All Writers should receive screen.")
        assertNotNull(secondSpy.screen, "All Writers should receive screen.")
        assertNull(firstSpy.event, "Event should not be received on screen view.")
        assertNull(secondSpy.event, "Event should not be received on screen view.")
        assertNull(firstSpy.properties, "property should not be received on screen view.")
        assertNull(secondSpy.properties, "property should not be received on screen view.")
    }

    @Test
    fun testReceiveEvent() {
        val firstSpy = WriterSpy()
        val secondSpy = WriterSpy()
        val writer = CompositeAnalyticsWriter(setOf(firstSpy, secondSpy))

        writer.writeEvent("Test", emptyList())

        assertNull(firstSpy.screen, "Screen view should not be received on event.")
        assertNull(secondSpy.screen, "Screen view should not be received on event.")
        assertNotNull(firstSpy.event, "All writers should receive event.")
        assertNotNull(secondSpy.event, "All writers should receive event.")
        assertNull(firstSpy.properties, "property should not be received on event.")
        assertNull(secondSpy.properties, "property should not be received on event.")
    }

    @Test
    fun testReceiveProperties() {
        val firstSpy = WriterSpy()
        val secondSpy = WriterSpy()
        val writer = CompositeAnalyticsWriter(setOf(firstSpy, secondSpy))

        writer.writeProperties(emptyList())

        assertNull(firstSpy.screen, "Screen view should not be received on property.")
        assertNull(secondSpy.screen, "Screen view should not be received on property.")
        assertNull(firstSpy.event, "Event should not be received on property.")
        assertNull(secondSpy.event, "Event should not be received on property.")
        assertNotNull(firstSpy.properties, "All writers should receive property..")
        assertNotNull(secondSpy.properties, "All writers should receive property..")
    }
}


package kimchi.logger

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CompositeLogWriterTest {
    @Test
    fun testReceive() {
        val firstSpy = WriterSpy()
        val secondSpy = WriterSpy()
        val writer = CompositeLogWriter(setOf(firstSpy, secondSpy))

        writer.log(LogLevel.TRACE, "Test")

        assertTrue(firstSpy.logged, "Composite should invoke all writers")
        assertTrue(secondSpy.logged, "Composite should invoke all writers")
    }

    @Test
    fun disabled() {
        val spy = WriterSpy(write = false)
        val writer = CompositeLogWriter(setOf(spy))

        writer.log(LogLevel.TRACE, "Test")

        assertFalse(spy.logged, "Composite should not invoke log when disabled.")
    }
    @Test
    fun mixed() {
        val firstSpy = WriterSpy()
        val secondSpy = WriterSpy(write = false)
        val writer = CompositeLogWriter(setOf(firstSpy, secondSpy))

        writer.log(LogLevel.TRACE, "Test")

        assertTrue(firstSpy.logged, "Writer should invoke log when enabled")
        assertFalse(secondSpy.logged, "Composite should not invoke log when disabled.")
    }
}

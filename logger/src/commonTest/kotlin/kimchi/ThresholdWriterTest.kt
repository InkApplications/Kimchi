package kimchi

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ThresholdWriterTest {
    @Test
    fun lowestLogLevel() {
        val spy = WriterSpy()
        val writer = ThresholdWriter(LogLevel.TRACE, spy)

        assertTrue(writer.shouldLog(LogLevel.TRACE), "All logs are enabled on lowest level")
        assertTrue(writer.shouldLog(LogLevel.DEBUG), "All logs are enabled on lowest level")
        assertTrue(writer.shouldLog(LogLevel.INFO), "All logs are enabled on lowest level")
        assertTrue(writer.shouldLog(LogLevel.WARNING), "All logs are enabled on lowest level")
        assertTrue(writer.shouldLog(LogLevel.ERROR), "All logs are enabled on lowest level")
    }

    @Test
    fun highestLevel() {
        val spy = WriterSpy()
        val writer = ThresholdWriter(LogLevel.ERROR, spy)

        assertFalse(writer.shouldLog(LogLevel.TRACE), "Logs should be disabled when lower level than threshold")
        assertFalse(writer.shouldLog(LogLevel.DEBUG), "Logs should be disabled when lower level than threshold")
        assertFalse(writer.shouldLog(LogLevel.INFO), "Logs should be disabled when lower level than threshold")
        assertFalse(writer.shouldLog(LogLevel.WARNING), "Logs should be disabled when lower level than threshold")
        assertTrue(writer.shouldLog(LogLevel.ERROR), "Logs equal or higher to threshold should be enabledd")
    }

    @Test
    fun disabled() {
        val spy = WriterSpy(write = false)
        val writer = ThresholdWriter(LogLevel.TRACE, spy)

        assertFalse(writer.shouldLog(LogLevel.TRACE), "Logs should be disabled when delegate is disabled.")
        assertFalse(writer.shouldLog(LogLevel.DEBUG), "Logs should be disabled when delegate is disabled.")
        assertFalse(writer.shouldLog(LogLevel.INFO), "Logs should be disabled when delegate is disabled.")
        assertFalse(writer.shouldLog(LogLevel.WARNING), "Logs should be disabled when delegate is disabled.")
        assertFalse(writer.shouldLog(LogLevel.ERROR), "Logs should be disabled when delegate is disabled.")
    }
}

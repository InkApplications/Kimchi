package kimchi

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StatefulWriterTest {
    @Test
    fun noWriters() {
        val writer = StatefulWriter()

        val shouldLog = writer.shouldLog(LogLevel.ERROR, Exception())
        writer.log(LogLevel.DEBUG, "Test")

        assertFalse(shouldLog, "Empty Writer State should not log")
    }

    @Test
    fun disabledWriter() {
        val spy = WriterSpy(write = false)
        val writer = StatefulWriter()

        writer.add(spy)
        val shouldLog = writer.shouldLog(LogLevel.WARNING)
        writer.log(LogLevel.TRACE, "Test")

        assertFalse(shouldLog, "Writer with only disabled delegates should not log")
        assertFalse(spy.logged, "Disabled delegate should not receive a log")
    }

    @Test
    fun enabledWriter() {
        val disabledSpy = WriterSpy(write = false)
        val enabledSpy = WriterSpy()
        val writer = StatefulWriter()

        writer.add(disabledSpy)
        writer.add(enabledSpy)
        val shouldLog = writer.shouldLog(LogLevel.WARNING)
        writer.log(LogLevel.TRACE, "Test")

        assertTrue(shouldLog, "Writer with an enabled delegate should log")
        assertFalse(disabledSpy.logged, "Disabled delegate should not receive a log")
        assertTrue(enabledSpy.logged, "Enabled delegate should receive a log")
    }

    @Test
    fun removeLogger() {
        val spy = WriterSpy()
        val writer = StatefulWriter()

        writer.add(spy)
        writer.remove(spy)
        val shouldLog = writer.shouldLog(LogLevel.WARNING)
        writer.log(LogLevel.INFO, "Test")

        assertFalse(shouldLog, "Empty Writer State should not log")
        assertFalse(spy.logged, "Removed writer should not receive logs")
    }

    @Test
    fun clearLoggers() {
        val spy = WriterSpy()
        val writer = StatefulWriter()

        writer.add(spy)
        writer.clear()
        val shouldLog = writer.shouldLog(LogLevel.WARNING)
        writer.log(LogLevel.INFO, "Test")

        assertFalse(shouldLog, "Empty Writer State should not log")
        assertFalse(spy.logged, "Removed writer should not receive logs")
    }
}

package kimchi.logger

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ConsolidatedLoggerTest {
    @Test
    fun logged() {
        val spy = WriterSpy()
        val exception = RuntimeException("Test Error")
        val logger = ConsolidatedLogger(spy)

        logger.trace("Test", exception)

        val (level, message, cause) = spy.log ?: throw RuntimeException("Log not received")

        assertEquals(LogLevel.TRACE, level)
        assertEquals("Test", message)
        assertEquals("Test Error", cause?.message)
    }
    @Test
    fun notLogged() {
        val spy = WriterSpy(write = false)
        val logger = ConsolidatedLogger(spy)

        logger.trace("Test")

        assertFalse(spy.logged, "Writer should not be invoked when not writing.")
    }

    @Test
    fun lazyNotInvoked() {
        val spy = WriterSpy(write = false)
        val logger = ConsolidatedLogger(spy)

        logger.error {
            throw Exception("Lazy should not be invoked.")
        }

        assertFalse(spy.logged, "Logger should not invoke non-writing logger.")
    }

    @Test
    fun lazyInvoked() {
        val spy = WriterSpy()
        val logger = ConsolidatedLogger(spy)
        var lazyInvoked = false
        logger.warn {
            lazyInvoked = true
            "Test"
        }

        assertTrue(lazyInvoked, "Logger should invoke lazy if logging enabled.")
        assertTrue(spy.logged, "Logger should invoke lazy if logging enabled.")
    }
}

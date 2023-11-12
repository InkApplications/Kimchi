package kimchi.logger.android

import kotlin.test.Test
import kotlin.test.assertEquals

class TagsTest: TestDefaults {
    @Test
    fun test() {
        val tag = Tags.getStackTag()

        assertEquals("TagsTest", tag)
    }

    @Test
    fun anonymous() {
        val anonymousFunction: () -> String = {
            Tags.getStackTag()
        }

        assertEquals("TagsTest", anonymousFunction())
    }

    @Test
    fun defaults() {
        val tag = default()

        assertEquals("TagsTest", tag)
    }
}

interface TestDefaults {
    fun default() = Tags.getStackTag()
}

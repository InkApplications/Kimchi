package kimchi.analytics

/**
 * Limited set of key/value data types.
 *
 * All properties must boil down to one of these primitive types so that they
 * can be recorded properly by most systems.
 * Use the static methods to create these, and create your own for more complex
 * types, but everything must be backed by one of these property types.
 *
 * @see intProperty Static method to create a property from an Integer
 * @see doubleProperty Static method to create a property from an Double
 * @see floatProperty Static method to create a property from an Float
 * @see longProperty Static method to create a property from an Long
 * @see stringProperty Static method to create a property from an String
 */
sealed class Property<out T: Any> {
    /**
     * Identifier unique to the property.
     */
    abstract val key: String

    /**
     * Recorded value of the property.
     */
    abstract val value: T

    data class IntProperty(
        override val key: String,
        override val value: Int
    ): Property<Int>()

    data class DoubleProperty(
        override val key: String,
        override val value: Double
    ): Property<Double>()

    data class FloatProperty(
        override val key: String,
        override val value: Float
    ): Property<Float>()

    data class LongProperty(
        override val key: String,
        override val value: Long
    ): Property<Long>()

    data class StringProperty(
        override val key: String,
        override val value: String
    ): Property<String>()
}

/**
 * Create a property from an Integer.
 */
fun intProperty(key: String, value: Int) = Property.IntProperty(key, value)

/**
 * Create a property from a Double.
 */
fun doubleProperty(key: String, value: Double) = Property.DoubleProperty(key, value)

/**
 * Create a property from a Float.
 */
fun floatProperty(key: String, value: Float) = Property.FloatProperty(key, value)

/**
 * Create a property from a Long.
 */
fun longProperty(key: String, value: Long) = Property.LongProperty(key, value)

/**
 * Create a property from a String
 */
fun stringProperty(key: String, value: String) = Property.StringProperty(key, value)

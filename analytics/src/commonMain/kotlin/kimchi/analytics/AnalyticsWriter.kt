package kimchi.analytics

/**
 * Service for sending events and properties to an analytics platform.
 */
interface AnalyticsWriter {
    /**
     * Write an application-level setting.
     *
     * This is for information like user info associated with all events in the
     * session. Not for a particular event.
     *
     * @param properties Key/Value pairs to describe the application state.
     */
    fun writeProperties(properties: List<Property<Any>>)

    /**
     * Send an event to the platform.
     *
     * @param name The Identifier of the event type.
     * @param properties Key:value pairs of information to send with the event.
     */
    fun writeEvent(name: String, properties: List<Property<Any>>)

    /**
     * Record that a screen was viewed.
     *
     * @param name The identifier of the screen, or its name.
     * @param properties Key:value pairs of information to qualify the screen view.
     */
    fun writeScreen(name: String, properties: List<Property<Any>>)
}



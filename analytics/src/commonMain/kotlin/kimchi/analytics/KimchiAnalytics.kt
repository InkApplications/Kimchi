package kimchi.analytics

/**
 * Main Analytics Interface.
 *
 * Used as the primary API for sending analytics with Kimchi. It can be used
 * directly in place of the static facade to inject analytics, where applicable.
 */
interface KimchiAnalytics {
    /**
     * Set a single application-level property.
     *
     * This is for information like user info associated with all events in the
     * session. Not for a particular event.
     *
     * @see setProperties to set multiple properties at once.
     * @param property Key/Value pair to describe the application state.
     */
    fun setProperty(property: Property<Any>)

    /**
     * Set application-level properties.
     *
     * This is for information like user info associated with all events in the
     * session. Not for a particular event.
     *
     * @see setProperties to set multiple properties at once.
     * @param properties Key/Value pairs to describe the application state.
     */
    fun setProperties(properties: List<Property<Any>>)

    /**
     * Send a report that an event occurred.
     *
     * @param name Identifier for the type of event.
     * @param properties key:value pairs of data to associate with the event. (optional)
     */
    fun trackEvent(name: String, properties: List<Property<Any>> = emptyList())

    /**
     * Track that a screen was viewed.
     *
     * @param name The identifier of the screen, or its name.
     * @param properties Key:value pairs of information to qualify the screen view.
     */
    fun trackScreen(name: String, properties: List<Property<Any>> = emptyList())
}

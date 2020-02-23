Kimchi
======

Kimchi is a multi-platform logging and analytics tool written in Kotlin.

## Logging

To use the logger, just add a log writer to determine where to write logs to:

```kotlin
fun main() {
    // Add one or more log writers:
    Kimchi.addLog(StandardWriter)

    // Send Logs:
    Kimchi.info("Hello World")
}
```

You can filter logs by level using a Threshold:

```kotlin
fun main() {
    Kimchi.add(StandardWriter.withThreshold(LogLevel.INFO))

    // Logs lower than the threshold will not show up:
    Kimchi.trace("This log is filtered")
    Kimchi.info("This log still shows!")
}
```

If generating a log string is expensive, you can lazily generate the log string
with a lambda, which will not be invoked if the log is disabled:

```kotlin
fun main() {
    Kimchi.addLog(StandardWriter.withThreshold(LogLevel.INFO)

    Kimchi.debug { "Getting this log could be expensive: ${getExpensiveInfo()}" }
}
```

### Android

The `logger-android` module provides Android logging to ADB:

```kotlin
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Kimchi.addLog(AdbWriter())

        Kimchi.info("Hello ADB!")
    }
}
```

## Analytics

Analytics is set up very similar to logging.
To start using analytics, you'll need to add a writer, just like logging:

```kotlin
fun main() {
    // Add one or more analytics writers:
    Kimchi.addAnalytics(KimchiLoggerAnalytics) // send analytics events to the logger.

    // Send Analytics Events:
    Kimchi.trackEvent("Hello Analytics!")
}
```

### Properties

Most analytics platforms allow you to set application-wide properties. These
can be used to describe the application state or user info that persists across
multiple events.

```kotlin
fun main() {
    Kimchi.setProperty(intProperty("age", 25))
}
```

Properties can be created for any of the following primitive types:

 - `stringProperty`
 - `intProperty`
 - `floatProperty`
 - `doubleProperty`
 - `longProperty`

To use custom types, simply create an extension to meet your needs. As long as
the type can be simplified into one of the primitive types supported by
analytics platforms, it can be recorded. For example:

```kotlin
/**
 * Create a property from a Java time Instant
 */
fun timestampProperty(name: String, time: Instant) = longProperty(name, time.toEpochMilli())

fun example() {
    Kimchi.setProperty(timestampProperty("Start Time", Instant.now()))
}
```

Properties can also be included in events and screen tracking:

```
fun example() {
    Kimchi.trackEvent(
        name = "Purchase Complete",
        properties = listOf(
            intProperty("Items", 5),
            stringProperty("State", "CA")
        )
    )
}
```

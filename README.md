Kimchi
======

Kimchi is a multi-platform logging and analytics tool written in Kotlin.

## Logging

To use the logger, just add a log writer to determine where to write logs to:

```kotlin
fun main() {
    // Add one or more log writers:
    Kimchi.add(StandardWriter)

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

### Android

The `logger-android` module provides Android logging to ADB:

```kotlin
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Kimchi.add(AdbWriter)

        Kimchi.info("Hello ADB")
    }
}
```

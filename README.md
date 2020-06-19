Kimchi
======

Kimchi is a multiplatform logging and analytics tool written in Kotlin.

## Logging

Start logging by adding a writer and sending logs:

```kotlin
fun main() {
    // Add one or more log writers:
    Kimchi.addLog(defaultWriter)

    // Send Logs:
    Kimchi.info("Hello World")
}
```

## Analytics

Analytics is as easy as logging!
Just like the logger, just add a writer and start tracking events:

```kotlin
fun main() {
    // Add one or more analytics writers:
    Kimchi.addAnalytics(KimchiLoggerAnalytics) // send analytics events to the logger.

    // Send Analytics Events:
    Kimchi.trackEvent("Hello Analytics!")
}
```

## Installation

Requires the JitPack repository:

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

```gradle
compile "com.github.Inkapplications.kimchi:kimchi:+" // Replace with exact version
```

## Documentation

For more examples and documentation please see [the website](https://kimchi.inkapplications.com)

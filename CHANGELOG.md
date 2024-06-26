Change Log
==========

2.2.0
-----

### Changed

 - Updated to Kotlin 2.0

2.1.0
-----

### Added
- Added all 3 Native [Tiers] for platform targets

### Changed

- Updated to Kotlin 1.9

[Tiers]: https://kotlinlang.org/docs/native-target-support.html#tier-1

2.0.3
-----

### Fixed
 - Fix for JS IR support

2.0.2
-----

### Fixed
 - Fix to add Android debug publication for logger module.

2.0.1
-----

### Fixed

 - Fixed a publication issue in the Android platform module.

2.0.0
-----

This major release is because the platform list has changed. The list of
supported platforms has expanded, however some linux platforms were removed
to support an internal dependency change to using KotlinX Coroutines.

### Changed
 - Updated to Kotlin 1.7
 - Updated Supported Platforms:
     - jvm
     - android
     - iOS:
        - iosArm32
        - iosArm64
        - iosX64
        - iosSimulatorArm64
     - WatchOS:
        - watchosArm32
        - watchosArm64
        - watchosX86
        - watchosX64
        - watchosSimulatorArm64
    - tvOS:
        - tvosArm64
        - tvosX64
        - tvosSimulatorArm64
    - MacOS:
        - macosX64
        - macosArm64
    - Linux:
        - linuxX64
    - Windows:
        - mingwX64

1.1.0
-----

### Added
 - Native Platform Support

### Changed
 - Update to Kotlin 1.4
 - Rename `kimchi` module to `core`

1.0.2
-----

 - Remove Excess Logs in Android platforms

1.0.1
-----

 - Fixed ADB Tagging for anonymous classes showing incorrect class.

1.0.0
-----

Released initial support for JS, Android and JVM logging and analytics.
API's are considered stable here forward and will be semantically versioned.

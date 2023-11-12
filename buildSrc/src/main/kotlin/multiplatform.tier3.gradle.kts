plugins {
    kotlin("multiplatform")
    id("multiplatform.tier2")
}

repositories {
    mavenCentral()
}

kotlin {
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    mingwX64()
    watchosDeviceArm64()
}


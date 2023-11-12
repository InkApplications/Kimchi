plugins {
    kotlin("multiplatform")
    id("multiplatform.tier1")
}

repositories {
    mavenCentral()
}

kotlin {
    linuxX64()
    linuxArm64()
    watchosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    tvosSimulatorArm64()
    tvosX64()
    tvosArm64()
    iosArm64()
}


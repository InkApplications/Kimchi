plugins {
    `kotlin-dsl`
}
repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.android.gradle)
    implementation(libs.dokka)
    implementation(libs.kotlinx.binary.compatibility)
}

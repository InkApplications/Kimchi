plugins {
    `kotlin-dsl`
}
repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}
dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.android.gradle)
}

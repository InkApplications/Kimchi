plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

android {
    compileSdkVersion(16)
}

dependencies {
    implementation(kotlin("stdlib"))
    api(project(":kimchi"))

    testImplementation(JUnit.runtime)
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

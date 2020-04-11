plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
        mavenPublication {
            artifactId = "logger-android"
        }
    }
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

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
}

kotlin {
    android {
        publishAllLibraryVariants()
        publishLibraryVariantsGroupedByFlavor = true
        mavenPublication {
            artifactId = "slogger-android"
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

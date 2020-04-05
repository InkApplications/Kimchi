import com.android.build.gradle.internal.scope.publishArtifactToConfiguration

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
}

android {
    compileSdkVersion(16)
}

dependencies {
    implementation(kotlin("stdlib"))
    api(project(":kimchi"))

    testImplementation(jUnit())
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

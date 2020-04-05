plugins {
    id("com.android.library")
    kotlin("android")
    id("com.github.dcendents.android-maven")
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

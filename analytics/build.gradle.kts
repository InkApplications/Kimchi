plugins {
    kotlin("multiplatform")
    id("kotlinx-atomicfu")
    id("maven-publish")
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(kotlin("stdlib"))
    commonMainImplementation(atomicFu())

    commonTestImplementation(jUnit())
    commonTestImplementation("org.jetbrains.kotlin:kotlin-test")
    commonTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

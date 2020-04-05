plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(kotlin("stdlib"))
    commonMainApi(project(":analytics"))
    commonMainImplementation(project(":logger"))

    commonTestImplementation(jUnit())
    commonTestImplementation("org.jetbrains.kotlin:kotlin-test")
    commonTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

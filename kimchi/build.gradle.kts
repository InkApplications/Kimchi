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
    commonMainApi(project(":logger"))
    commonMainImplementation(project(":analytics-logger"))
}

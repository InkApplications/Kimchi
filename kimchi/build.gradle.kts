plugins {
    kotlin("multiplatform")
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

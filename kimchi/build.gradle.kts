plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
}

dependencies {
    commonMainImplementation(kotlin("stdlib"))
    commonMainApi(project(":logger"))
}

plugins {
    kotlin("multiplatform")
}

dependencies {
    commonMainImplementation(kotlin("stdlib"))
    commonMainApi(project(":logger"))
}

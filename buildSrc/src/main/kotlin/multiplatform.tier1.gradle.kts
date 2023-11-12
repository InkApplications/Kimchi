plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
    jvm()
    js(IR) {
        nodejs()
        browser()
        browser {
            testTask {
                useKarma {
                    useFirefoxHeadless()
                }
            }
        }
    }
    macosX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()
}


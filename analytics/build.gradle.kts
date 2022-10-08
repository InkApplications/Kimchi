plugins {
    id("ink.multiplatform")
    id("com.inkapplications.publishing")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines.core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(libs.kotlin.test.junit)
            }
        }
    }
}

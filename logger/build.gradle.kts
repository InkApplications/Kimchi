plugins {
    id("ink.multiplatform")
    id("com.android.library")
    id("com.inkapplications.publishing")
}

android {
    compileSdkVersion(33)
    lintOptions {
        tasks.lint {
            enabled = false
        }
    }
}

kotlin {
    android {
        publishAllLibraryVariants()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines.core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(libs.kotlin.test.core)
                implementation(libs.kotlin.test.junit)
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(libs.kotlin.test.core)
                implementation(libs.kotlin.test.junit)
            }
        }
    }
}

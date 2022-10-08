plugins {
    id("ink.multiplatform")
    id("com.inkapplications.publishing")
    id( "com.android.library")
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
        publishLibraryVariantsGroupedByFlavor = true
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

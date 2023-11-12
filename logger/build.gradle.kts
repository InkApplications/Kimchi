plugins {
    id("multiplatform.tier3")
    id("com.android.library")
    id("ink.publishing")
}

android {
    compileSdk = 34
    namespace = "com.inkapplications.kimchi.logger"
}

kotlin {
    androidTarget {
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

        val androidUnitTest by getting {
            dependencies {
                implementation(libs.kotlin.test.core)
                implementation(libs.kotlin.test.junit)
            }
        }
    }
}

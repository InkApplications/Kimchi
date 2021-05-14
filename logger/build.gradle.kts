plugins {
    kotlin("multiplatform")
    id( "com.android.library")
    id("maven-publish")
}

android {
    compileSdkVersion(16)
}

kotlin {
    jvm()
    android {
        publishAllLibraryVariants()
        publishLibraryVariantsGroupedByFlavor = true
    }
    js()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.subatomic)
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

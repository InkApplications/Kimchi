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
                implementation(kotlin("stdlib-common"))
                implementation(Subatomic.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation(JUnit.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(Subatomic.core)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}

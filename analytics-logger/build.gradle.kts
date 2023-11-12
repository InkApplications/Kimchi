plugins {
    id("multiplatform.tier3")
    id("ink.publishing")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.analytics)
                implementation(projects.logger)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(libs.kotlin.test.junit)
            }
        }
    }
}

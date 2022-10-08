plugins {
    id("ink.multiplatform")
    id("com.inkapplications.publishing")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.analytics)
                api(projects.logger)
                implementation(projects.analyticsLogger)
            }
        }
    }
}

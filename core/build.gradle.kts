plugins {
    id("multiplatform.tier3")
    id("ink.publishing")
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

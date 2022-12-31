plugins {
    id("ink.multiplatform")
    id("com.android.library")
    id("maven-publish")
    id("signing")
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

afterEvaluate {
    publishing {
        publications {
            val versionArg = when (project.properties["version"]?.toString()) {
                null, "unspecified", "" -> "1.0-SNAPSHOT"
                else -> project.properties["version"].toString()
            }

            create<MavenPublication>("release") {
                from(components["release"])
                version = versionArg
            }
        }
        repositories {
            maven {
                name = "Build"
                url = uri(layout.buildDirectory.dir("repo"))
            }

            val mavenUser: String? by project
            val mavenPassword: String? by project
            if (mavenUser != null && mavenPassword != null) {
                maven {
                    name = "MavenCentral"
                    url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                    credentials {
                        username = mavenUser
                        password = mavenPassword
                    }
                }
            }
        }
    }
}
publishing {
    signing {
        val signingKeyId: String? by project
        val signingKey: String? by project
        val signingPassword: String? by project

        if (signingKey != null) {
            if (signingKeyId != null) {
                useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
            } else {
                useInMemoryPgpKeys(signingKey, signingPassword)
            }
            sign(publishing.publications)
            sign(configurations["archives"])
        }
    }
}

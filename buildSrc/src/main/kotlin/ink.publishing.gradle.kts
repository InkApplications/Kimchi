plugins {
    id("maven-publish")
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    group = "com.inkapplications.kimchi"
    version = when (project.properties["version"]?.toString()) {
        null, "unspecified", "" -> "1.1-SNAPSHOT"
        else -> project.properties["version"].toString()
    }
    publications {
        withType<MavenPublication> {
            artifact(javadocJar.get())

            pom {
                name.set("Kimchi: ${project.name}")
                description.set("Multiplatform logging tools")
                url.set("https://github.com/inkapplications/kimchi")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://choosealicense.com/licenses/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("reneevandervelde")
                        name.set("Renee Vandervelde")
                        email.set("Renee@InkApplications.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/InkApplications/kimchi.git")
                    developerConnection.set("scm:git:ssh://git@github.com:InkApplications/kimchi.git")
                    url.set("https://github.com/InkApplications/kimchi")
                }
            }
        }
    }

    repositories {
        maven {
            name = "Build"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

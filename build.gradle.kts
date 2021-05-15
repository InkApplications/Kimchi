import org.gradle.api.tasks.testing.logging.TestExceptionFormat

subprojects {
    repositories {
        mavenCentral()
        google()
    }
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
}

tasks.create("zipPublications", Zip::class) {
    from("analytics/build/repo/")
    from("analytics-logger/build/repo/")
    from("core/build/repo/")
    from("logger/build/repo/")
    archiveFileName.set("publications.zip")
}

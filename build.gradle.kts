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

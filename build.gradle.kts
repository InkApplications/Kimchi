import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.5.0"))
        classpath("com.android.tools.build:gradle:4.2.0")
    }
}

subprojects {
    group = "com.github.inkapplications.kimchi"
    version = if (version != "unspecified") version else "1.0-SNAPSHOT"

    repositories {
        jcenter()
        google()
        maven(url = "https://jitpack.io")
    }
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
}

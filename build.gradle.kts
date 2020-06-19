import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
        classpath("com.android.tools.build:gradle:3.6.3")
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

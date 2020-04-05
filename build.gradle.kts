import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.61"))
        classpath(atomicFu("gradle-plugin"))
        classpath("com.android.tools.build:gradle:3.5.2")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

subprojects {
    group = "com.inkapplications.kimchi"
    version = if (version != "unspecified") version else "1.0-SNAPSHOT"

    repositories {
        jcenter()
        google()
    }
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
}

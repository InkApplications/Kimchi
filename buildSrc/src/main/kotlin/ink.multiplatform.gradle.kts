plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    iosArm32()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    watchosArm32()
    watchosArm64()
    watchosX86()
    watchosX64()
    watchosSimulatorArm64()

    tvosArm64()
    tvosX64()
    tvosSimulatorArm64()

    macosX64()
    macosArm64()

    linuxX64()

    mingwX64()

    js {
        nodejs()
        browser()
    }

    sourceSets{
        val commonMain by sourceSets.getting

        val linuxX64Main by sourceSets.getting
        val macosArm64Main by sourceSets.getting
        val macosX64Main by sourceSets.getting
        val mingwX64Main by sourceSets.getting

        val nativeMain by sourceSets.creating {
            dependsOn(commonMain)
            linuxX64Main.dependsOn(this)
            linuxX64Main.dependsOn(this)
            macosArm64Main.dependsOn(this)
            macosX64Main.dependsOn(this)
            mingwX64Main.dependsOn(this)
        }

        val iosArm32Main by sourceSets.getting
        val iosArm64Main by sourceSets.getting
        val iosX64Main by sourceSets.getting
        val iosSimulatorArm64Main by sourceSets.getting
        val watchosArm32Main by sourceSets.getting
        val watchosArm64Main by sourceSets.getting
        val watchosX86Main by sourceSets.getting
        val watchosX64Main by sourceSets.getting
        val watchosSimulatorArm64Main by sourceSets.getting
        val tvosArm64Main by sourceSets.getting
        val tvosX64Main by sourceSets.getting

        val iosMain by sourceSets.creating {
            dependsOn(commonMain)
            iosArm32Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosX64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            watchosArm32Main.dependsOn(this)
            watchosArm64Main.dependsOn(this)
            watchosX86Main.dependsOn(this)
            watchosX64Main.dependsOn(this)
            watchosSimulatorArm64Main.dependsOn(this)
            tvosArm64Main.dependsOn(this)
            tvosX64Main.dependsOn(this)
        }
    }
}

plugins {
    kotlin("jvm") version "1.9.23"
}

group = "rocks.aendu.kotlin-in-action-2nd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
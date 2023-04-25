plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.3.1")
    implementation("com.opencsv:opencsv:5.7")
    implementation("com.googlecode.json-simple:json-simple:1.1")
    testImplementation("com.google.code.gson:gson:2.10.1")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.15.0-rc1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.0")

}

tasks.test {
    useJUnitPlatform()
}
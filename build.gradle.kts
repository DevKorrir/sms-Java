plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "com.example"
version = "1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.example.sms_java.MainApp")
    applicationDefaultJvmArgs = listOf(
        "--enable-native-access=javafx.graphics",
        "-Dprism.order=sw,es2,d3d"
    )
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics")
}

dependencies {
    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.3")
    implementation("org.controlsfx:controlsfx:11.2.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.12.1")
}

tasks.test {
    useJUnitPlatform()
}

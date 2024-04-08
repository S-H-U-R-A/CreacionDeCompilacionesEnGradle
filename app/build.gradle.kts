plugins {
    `kotlin-dsl`
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.example.license")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation(project(":lib")) //Acá agregamos el módulo lib al proyecto general

    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

println("BUILD SCRIPT: archivo de compilación del módulo app, este es ejecutado en la fase de configuración")

tasks.register("task1"){
    println("REGISTER TASK1: Esta tarea es ejecutada en la fase configuración")
}

tasks.named("task1"){
    doFirst {
        println("NAMED TASK1 - doFirst: Esto es ejecutado en la fase de ejecución")
    }
    doLast {
        println("NAMED TASK1 - doLast: Esto es ejecutado en la fase de ejecución")
    }
}

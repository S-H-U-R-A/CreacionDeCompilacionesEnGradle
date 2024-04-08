plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.guava:guava:32.1.1-jre")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register("task3"){
    println("REGISTER TASK3: Esta es ejecutada en la fase configuración")
}

tasks.named("task3"){
    println("NAMED TASK3: Esta es ejecutada en la fase configuración")
    doFirst {
        println("NAMED TASK3 - doFirst: Esta es ejecuttada en la fase ejecución")
    }
    doLast {
        println("NAMED TASK3 - doLast: Esta es ejecuttada en la fase ejecución")
    }
}
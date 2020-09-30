plugins {
    id("ru.mipt.npm.mpp")
}

kotlin.sourceSets {
    commonMain {
        dependencies {
            api(project(":kmath-core"))
        }
    }

    jvmMain {
        dependencies {
            implementation("org.ow2.asm:asm:8.0.1")
            implementation("org.ow2.asm:asm-commons:8.0.1")
            implementation("com.github.h0tk3y.betterParse:better-parse:0.4.0")
        }
    }
}

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

val ktor_version: String by project

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    jvm("desktop")
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val desktopMain by getting
        
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.8.0")
            implementation("io.ktor:ktor-client-core:$ktor_version")
            implementation("io.ktor:ktor-client-okhttp:$ktor_version")
            implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}



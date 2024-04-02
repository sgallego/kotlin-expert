
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

val ktor_version: String by project

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting

        desktopMain.dependencies {
            implementation(project(":common"))
            implementation(compose.desktop.currentOs)
        }
    }
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.apptitudecode.kenotes"
            packageVersion = "1.0.0"
        }
    }
}

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

val ktor_version: String by project

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    targetHierarchy.default()
    androidTarget()
    jvm("desktop"){
        jvmToolchain(11)
    }
    js(IR){
        browser()
    }

    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "common"
            linkerOpts("-framework", "CoreGraphics")
            linkerOpts("-framework", "CoreText")
            linkerOpts("-framework", "Metal")
        }
    }

    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(compose.materialIconsExtended)
                implementation(libs.voyagerNavigator)
                implementation(libs.voyagerScreenModel)

                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
            }

        }
        val commonTest by getting

        val commonComposeKmpMain by creating{
            dependsOn(commonMain)
        }


        val desktopMain by getting{
            dependsOn(commonComposeKmpMain)
            dependencies {

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.8.0")
                implementation("io.ktor:ktor-client-okhttp:$ktor_version")

                implementation(compose.desktop.currentOs)
            }
        }

        val androidMain by getting{
            dependsOn(commonComposeKmpMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
                implementation("io.ktor:ktor-client-okhttp:$ktor_version")
            }
        }

        val androidUnitTest by getting

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-js:$ktor_version")
            }
        }
        val jsTest by getting

        val iosMain by getting
    }
}

android {
    namespace = "com.sgallego.kotlinexpert"
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}



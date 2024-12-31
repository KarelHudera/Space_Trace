import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.buildConfig)
}

repositories {
    google()
    mavenCentral()
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    androidTarget {
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    jvmToolchain(21)

    jvm("desktop")

    js {
        browser()
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting
        val jsMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.core.splashscreen)
            implementation(libs.ktor.client.android)
            implementation(libs.koin.android)
            implementation(libs.sqlDelight.driver.android)

            // Logging library
            implementation(libs.napier)
        }

        commonMain.dependencies {
            // Core libraries for UI and foundation
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)

            // Additional Compose tools
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // Android lifecycle libraries for Compose
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Voyager libraries for navigation and screen management
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.tabNavigator)
            implementation(libs.voyager.transitions)
            implementation(libs.voyager.screenModel)

            // Logging library
            implementation(libs.napier)

            // KotlinX serialization and datetime utilities
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)

            // Coil for image loading in Compose
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor3)

            // Ktor core libraries
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.logging)

            // Koin di
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            // Icons packs
            implementation(libs.composeIcons.evaIcons)

            // SQL extensions
            implementation(libs.sqlDelight.extensions)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
            implementation(libs.kotlinx.coroutines.test)

            // Logging library
            implementation(libs.napier)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.client.cio)
            implementation(libs.sqlDelight.driver.sqlite)

            // Logging library
            implementation(libs.napier)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqlDelight.driver.native)

            // Logging library
            implementation(libs.napier)
        }

        jsMain.dependencies {
            implementation(libs.ktor.client.js)
            implementation(compose.html.core)
         //   TODO()
//             implementation(libs.web.worker.driver)
//             implementation(libs.sqlDelight.driver.sqljs)
//            implementation(npm("sql.js", "1.6.2"))
//            implementation(devNpm("copy-webpack-plugin", "9.1.0"))

            // Logging library
            implementation(libs.napier)
        }
    }
}

android {
    namespace = "karel.hudera.spacetrace"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
        resources.srcDirs("src/commonMain/resources")
    }
    defaultConfig {
        applicationId = "karel.hudera.spacetrace"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

dependencies {
    androidTestImplementation(libs.androidx.uitest.junit4)
    debugImplementation(libs.androidx.uitest.testManifest)
}

compose.desktop {
    application {
        mainClass = "karel.hudera.spacetrace.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "karel.hudera.spacetrace"
            packageVersion = System.getenv("APP_VERSION") ?: "1.0.0"

            val iconBasePath = "src/desktopMain/resources/desktopAppIcons"
            linux {
                iconFile.set(project.file("$iconBasePath/LinuxIcon.png"))
            }
            windows {
                iconFile.set(project.file("$iconBasePath/WindowsIcon.ico"))
            }
            macOS {
                iconFile.set(project.file("$iconBasePath/MacosIcon.icns"))
                bundleID = "karel.hudera.spacetrace.desktopApp"
            }
        }
    }
}

buildConfig {
    // BuildConfig configuration here.
    // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("karel.hudera.spacetrace.db")
        }
    }
}
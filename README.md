# Space_Trace
This is a Compose Multiplatform project targeting Android, iOS, Web, Desktop.

![Platforms](https://img.shields.io/badge/Platforms-Android%20|%20iOS%20|%20macOS%20|%20Linux%20|%20Windows%20|%20WebJS-4387F6?logo=jetpackcompose&logoColor=white&style=plastic)

## Before running!
- check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
- install JDK 17 or higher on your machine
- add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:
- open project in Android Studio and run imported android run configuration

To build the application bundle:
- run `./gradlew :composeApp:assembleDebug`
- find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`
  Run android UI tests on the connected device: `./gradlew :composeApp:connectedDebugAndroidTest`

### Desktop
Run the desktop application: `./gradlew :composeApp:run`
Run desktop UI tests: `./gradlew :composeApp:jvmTest`

### iOS
To run the application on iPhone device/simulator:
- Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
- Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio
  Run iOS simulator UI tests: `./gradlew :composeApp:iosSimulatorArm64Test`

### JS Browser (Experimental)
Run the browser application: `./gradlew :composeApp:jsBrowserDevelopmentRun --continue`
Run browser UI tests: `./gradlew :composeApp:jsBrowserTest`

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

```mermaid
%%{
  init: {
    'theme': 'neutral'
  }
}%%
flowchart TB
    Repository <--> ViewModel
    View --> Intent
    Intent -->|Interprete| Action
    State -->|Render| View

    subgraph ViewModel
        Action -->|Process| Result
        Result -->|Reduce| State
    end
```
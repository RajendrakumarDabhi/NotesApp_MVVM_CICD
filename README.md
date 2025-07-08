# NotesApp MVVM CICD

A modern Android Notes application built with Kotlin, Jetpack Compose, MVVM architecture, Room, Hilt, and integrated CI/CD pipeline.

## Features
- Add, edit, delete notes
- Search notes
- Jetpack Compose UI
- MVVM architecture
- Room database for local storage
- Hilt for dependency injection
- CI/CD pipeline support

## Tech Stack
- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Architecture:** MVVM
- **Database:** Room
- **Dependency Injection:** Hilt
- **Build System:** Gradle (Kotlin DSL)
- **CI/CD:** (Describe your pipeline/tool here, e.g., GitHub Actions, Bitrise, etc.)

## Project Structure
```
NotesApp_MVVM_CICD/
├── app/
│   ├── src/
│   │   ├── main/
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/
│   └── libs.versions.toml
├── gradle.properties
├── gradlew / gradlew.bat
└── ...
```

## Getting Started

### Prerequisites
- Android Studio (Giraffe or newer recommended)
- JDK 17+
- Gradle 8+

### Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/NotesApp_MVVM_CICD.git
   cd NotesApp_MVVM_CICD
   ```
2. **Open in Android Studio**
3. **Sync Gradle**
4. **Run the app** on an emulator or device

### Build & Run from Command Line
```sh
./gradlew assembleDebug
./gradlew installDebug
```

## CI/CD
- (Describe your CI/CD setup, e.g., GitHub Actions workflows, Bitrise, etc.)

## Dependencies
- Jetpack Compose
- Room
- Hilt
- Lifecycle
- Navigation Compose
- (See `gradle/libs.versions.toml` for all versions)

## Troubleshooting
- If you encounter unresolved plugin or dependency errors, ensure you have the correct repositories in your `settings.gradle.kts` and `build.gradle.kts` files:
  ```kotlin
  dependencyResolutionManagement {
      repositories {
          google()
          mavenCentral()
      }
  }
  ```
- Make sure your `gradle/libs.versions.toml` includes all required plugin aliases (android, kotlin, hilt, ksp, kapt, etc.)

## License
MIT License

---

**Author:** Your Name

For any issues, please open an issue on GitHub.


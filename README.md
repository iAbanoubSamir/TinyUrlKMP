# TinyUrlKMP - A Kotlin Multiplatform URL Shortener

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg) ![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.7.0-blue) ![Ktor](https://img.shields.io/badge/Ktor-Client-orange) ![Koin](https://img.shields.io/badge/Koin-DI-purple) ![SQLDelight](https://img.shields.io/badge/SQLDelight-Database-yellow)

## Overview

TinyUrlKMP is a Kotlin Multiplatform (KMP) app that lets you shorten long URLs into compact,
shareable links. Built with Compose Multiplatform, it provides a seamless experience across Android,
iOS, Desktop, and Web (via Kotlin/Wasm). The app integrates with the
official [TinyURL API](https://tinyurl.com/app/dev) to generate short links quickly and efficiently.

## Features

- ✂️ **URL Shortening:** Convert long links into short, shareable URLs instantly.
- 📜 **History Tracking:** Keep track of previously shortened URLs.
- 🎨 **Adaptive UI:** A modern, responsive design using Material3.
- ⚡ **Blazing Fast:** Smooth performance across platforms.

## Technologies Used

- **Kotlin Multiplatform (KMP):** Shared business logic across all platforms.
- **Compose Multiplatform:** Shared UI across all platforms.
- **Ktor:** Networking for API requests.
- **Koin:** Dependency injection.
- **SQLDelight:** Local database storage for link history.
- **Kotlinx.serialization:** JSON serialization.
- **Kotlinx.coroutines:** Asynchronous programming.
- **Kotlinx.datetime:** Date and time utilities.
- **Compose Navigation:** Smooth app navigation.
- **Material3 Adaptive Navigation:** Responsive navigation.

## Demo Video

Watch the app in action:

https://github.com/user-attachments/assets/7f7fc8be-73f4-47f3-9e17-0f1dd00c075d


## Getting Started

### Prerequisites

Ensure you have the following installed:

- Android Studio with the Kotlin Multiplatform Mobile plugin.
- Java Development Kit (JDK) 17 or higher.
- Node.js and npm (for Kotlin/Wasm support).

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/iAbanoubSamir/TinyUrlKMP.git
   ```
2. Open the project in **Android Studio**.
3. Sync the Gradle files.
4. Replace `YOUR_API_KEY` in
   `composeApp/src/commonMain/kotlin/com/tiny/url/shortener/data/network/LinkShortenerDataSource.kt`
   with your actual API token from: [TinyURL API](https://tinyurl.com/app/dev).

### Running the Project

- **Android:** Run the `composeApp` configuration in Android Studio.
- **iOS:** Run `iosApp` configuration in Xcode.
- **Desktop:** Execute the `:composeApp:run` Gradle task.
- **Web:** Use `:composeApp:wasmJsBrowserDevelopmentRun` in Android Studio.

## Contributing

🚀 Contributions are welcome! Feel free to open issues, submit pull requests, or suggest new
features.

## License

This project is licensed under the MIT License.

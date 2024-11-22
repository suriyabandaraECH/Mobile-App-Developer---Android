1. Project Setup Instructions: Clone the repository:

bash
Copy code
git clone <repository_url>
cd <project_directory>
Open the project in Android Studio:

Ensure you are using the latest version of Android Studio Giraffe or newer.
Install dependencies: Gradle will automatically download the required dependencies upon project sync.

Run the application:

Connect a physical Android device or use an emulator.
Build and run the project:
bash
Copy code
./gradlew installDebug

2. Libraries Used

First-party libraries:
Jetpack Compose: For building a modern declarative UI.

androidx.compose.ui and androidx.compose.material: To design a flexible and responsive interface.
Reason: Compose simplifies UI development with Kotlin.
Jetpack Navigation (Compose):

androidx.navigation:navigation-compose: For navigating between screens.
Reason: Streamlines app navigation in Compose-based projects.
Kotlin Coroutines & Flow:

kotlinx.coroutines and StateFlow: For managing asynchronous data streams.
Reason: Enables reactive programming and clean state management.
ViewModel:

androidx.lifecycle:lifecycle-viewmodel-compose: For lifecycle-aware state and data handling.
Reason: Centralized state management aligned with Android architecture best practices.


Third-party libraries:
Ktor:

io.ktor.client: For making HTTP API requests.
Reason: Lightweight, Kotlin-first HTTP client that integrates seamlessly with modern Android projects.
Coil:

io.coil-kt: For image loading.
Reason: Efficient and Compose-friendly image loading library, used to fetch planet icons.


3. Architecture Overview

This application follows the Model-View-ViewModel (MVVM) pattern:

Model:

Responsible for data operations.
SWAPI data is fetched using Ktor and encapsulated in data classes.
ViewModel:

Manages UI state using StateFlow.
Serves as the intermediary between the View and Model, ensuring separation of concerns.
Handles data retrieval and state updates for the UI.
View:

Built entirely using Jetpack Compose for a declarative and reactive UI.
Observes StateFlow from the ViewModel to render dynamic content.

4. Key Design Decisions

Modern Reactive Programming:
Used Kotlin Coroutines and Flow for seamless asynchronous operations and reactive state updates.
Reason: Kotlin Coroutines provide structured concurrency, and Flow ensures predictable, lifecycle-aware state handling.
Jetpack Compose:
Eliminated the need for XML layouts by adopting Compose for UI development.
Reason: Compose simplifies UI creation, enhances code readability, and supports dynamic UI updates through declarative programming.
Jetpack Navigation:
Integrated Compose Navigation for screen transitions.
Reason: Native Compose navigation makes navigation predictable and type-safe.


Here’s a comprehensive README.md file tailored to the project described:

Planet Explorer App
A mobile application that fetches and displays planet information from the Star Wars API (SWAPI) using modern Android development tools and libraries. Users can browse a list of planets, view details about individual planets, and enjoy an optional feature with planet icons.

1. Project Setup Instructions
Follow these steps to set up and run the project locally:

Clone the repository:

bash
Copy code
git clone <repository_url>
cd <project_directory>
Open the project in Android Studio:

Ensure you are using the latest version of Android Studio Giraffe or newer.
Install dependencies: Gradle will automatically download the required dependencies upon project sync.

Run the application:

Connect a physical Android device or use an emulator.
Build and run the project:
bash
Copy code
./gradlew installDebug
2. Libraries Used
First-party libraries:
Jetpack Compose: For building a modern declarative UI.

androidx.compose.ui and androidx.compose.material: To design a flexible and responsive interface.
Reason: Compose simplifies UI development with Kotlin.
Jetpack Navigation (Compose):

androidx.navigation:navigation-compose: For navigating between screens.
Reason: Streamlines app navigation in Compose-based projects.
Kotlin Coroutines & Flow:

kotlinx.coroutines and StateFlow: For managing asynchronous data streams.
Reason: Enables reactive programming and clean state management.
ViewModel:

androidx.lifecycle:lifecycle-viewmodel-compose: For lifecycle-aware state and data handling.
Reason: Centralized state management aligned with Android architecture best practices.
Third-party libraries:
Ktor:

io.ktor.client: For making HTTP API requests.
Reason: Lightweight, Kotlin-first HTTP client that integrates seamlessly with modern Android projects.
Coil:

io.coil-kt: For image loading.
Reason: Efficient and Compose-friendly image loading library, used to fetch planet icons.
3. Architecture Overview
This application follows the Model-View-ViewModel (MVVM) pattern:

Model:

Responsible for data operations.
SWAPI data is fetched using Ktor and encapsulated in data classes.
ViewModel:

Manages UI state using StateFlow.
Serves as the intermediary between the View and Model, ensuring separation of concerns.
Handles data retrieval and state updates for the UI.
View:

Built entirely using Jetpack Compose for a declarative and reactive UI.
Observes StateFlow from the ViewModel to render dynamic content.
Why MVVM?

Enables a reactive approach to data and state management.
Promotes clean separation of concerns for maintainability.
4. Key Design Decisions
Modern Reactive Programming:
Used Kotlin Coroutines and Flow for seamless asynchronous operations and reactive state updates.
Reason: Kotlin Coroutines provide structured concurrency, and Flow ensures predictable, lifecycle-aware state handling.
Jetpack Compose:
Eliminated the need for XML layouts by adopting Compose for UI development.
Reason: Compose simplifies UI creation, enhances code readability, and supports dynamic UI updates through declarative programming.
Jetpack Navigation:
Integrated Compose Navigation for screen transitions.
Reason: Native Compose navigation makes navigation predictable and type-safe.
5. Known Issues
Error Handling:

Limited handling for API request failures or connectivity issues.
Impact: The app may not display informative error messages in case of network issues.
Pagination:

The app currently fetches only the first page of planet data.
Impact: Does not support the full dataset from SWAPI.


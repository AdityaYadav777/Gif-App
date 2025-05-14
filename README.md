Features

Trending GIFs on Launch: Displays the most popular GIFs by default.

Search GIFs: Real-time search functionality based on user input.

Circular Progress Indicator: Shows a loading spinner while data is being fetched.

GIF Loading with Glide: Smooth and efficient image loading.

MVVM Architecture: Clean code separation using ViewModel and Observers.

Modular Codebase: Screens, components, and logic are divided into clear categories/folders.



---

Tech Stack

Jetpack Compose – Used for building the modern and declarative UI of the app.

Retrofit – Handles network requests to fetch data from the GIF API.

GsonConverterFactory – Parses JSON responses from the API into Kotlin data classes.

Glide – Loads and displays GIFs efficiently in the UI.

ViewModel – Manages UI-related data in a lifecycle-aware manner.

LiveData / StateFlow – Observes data changes and updates the UI reactively.

Project Structure

app/
│
├── components/         # Reusable Composables (GIF card, loader, etc.)
├── screens/            # HomeScreen, SearchScreen, etc.
├── network/            # API interface, Retrofit builder
├── viewmodel/          # ViewModel classes
├── model/              # Data models for GIFs           
└── MainActivity.kt     # App entry point


---

API Used

This app integrates with a GIF API like Giphy or Tenor using REST endpoints (you can add the actual API provider and key info here).


---

How to Run

1. Clone the Repository

git clone https://github.com/your-username/trending-gif-app.git
cd trending-gif-app


2. Open in Android Studio


3. Setup API Key

Replace YOUR_API_KEY in the API client file (usually inside network/ApiClient.kt) with your actual API key from Giphy/Tenor.



4. Build and Run

Click Run in Android Studio on a device or emulator (Android 7.0+).

Drive-Link:- https://drive.google.com/file/d/1S2nogjz9O9--5KL96-cDe1dIOIam-TGZ/view?usp=drivesdk

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "edu.example.shoppinglist"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.example.shoppinglist"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    val room = "2.6.1"
    val dagger = "2.51.1"
    val lifecycle = "2.7.0"

    implementation("androidx.room:room-ktx:$room")
    implementation("androidx.room:room-runtime:$room")
    ksp("androidx.room:room-compiler:$room")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")




    implementation ("com.google.dagger:dagger:$dagger")
    ksp ("com.google.dagger:dagger-compiler:$dagger")

    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
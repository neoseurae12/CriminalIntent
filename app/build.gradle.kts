plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.bignerdranch.android.criminalintent"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bignerdranch.android.criminalintent"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment.ktx)  // Fragment library
    implementation(libs.androidx.lifecycle.viewmodel.ktx)   // `lifecycle-viewmodel-ktx` library
    implementation(libs.androidx.recyclerview)  // RecyclerView library

    implementation(libs.xkotlinx.coroutines.core)   // core Coroutines library
    implementation(libs.kotlinx.coroutines.android) // a library to hook up the main thread in Android to the coroutines
    implementation(libs.androidx.lifecycle.runtime.ktx) // a library to enable me to safely consume data coming from a coroutine inside Fragment or Activity

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
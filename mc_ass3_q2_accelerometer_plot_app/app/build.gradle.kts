plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.accelerometer_ml_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.accelerometer_ml_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    implementation(libs.androidx.ui.tooling.preview.android)
//    implementation(libs.androidx.ui.android)
//    implementation(libs.androidx.appcompat)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//
//    implementation(libs.ui)
//    implementation(libs.androidx.material)
//    implementation(libs.ui.tooling.preview)
//    implementation (libs.androidx.lifecycle.runtime.ktx)
//    implementation (libs.androidx.activity.compose)
//    implementation (libs.accompanist.systemuicontroller)
//    implementation (libs.androidx.room.runtime)
//    implementation (libs.androidx.room.ktx)
//    ksp (libs.androidx.room.compiler)
//    implementation (libs.androidx.navigation.compose)
//    implementation (libs.kotlinx.coroutines.android)
//    // For accelerometer data
//    implementation (libs.androidx.core.sensor)
//
//
//
//    implementation (libs.androidx.navigation.compose)
//
//    implementation (libs.kotlinx.coroutines.android)
////    implementation (libs.MPAndroidChart)
////    debugImplementation (libs.ui.tooling)


    implementation ("androidx.core:core-ktx")  // Updated to the latest stable version
    implementation ("androidx.compose.ui:ui") // Use the correct version of Compose
    implementation ("androidx.compose.material:material")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx")
    implementation ("androidx.activity:activity-compose")
    implementation ("androidx.navigation:navigation-compose")

    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.material3.android)
    //implementation(libs.androidx.room.common)
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit.ktx)
    androidTestImplementation("org.testng:testng:6.9.6")
    ksp ("androidx.room:room-compiler:2.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android")


   // implementation ("com.github.PhilJay:MPAndroidChart")  // For charts

    debugImplementation ("androidx.compose.ui:ui-tooling")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")

//    implementation ("com.google.android.material:material:1.11.0")
//    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0") // MPAndroidChart library
//    // other dependencies
//
//    implementation ("com.github.AAChartModel:AAChartCore-Kotlin:5.1.0")



    // Add this line for the charting library
//    implementation ("com.github.tehras.charts:compose-line-chart")
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.6")




}
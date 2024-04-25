plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKapt)
    alias(libs.plugins.comGoogleDevToolKSP)
    alias(libs.plugins.comGoogleDaggerHiltAndroid)
}

android {
    namespace = "com.sundram.assignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sundram.assignment"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com\"")
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
        dataBinding = true
        buildConfig = true
    }
}

dependencies {


    //viewmodel and live data
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    kapt(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    //Retrofit
    implementation(libs.com.squareup.retrofit2.retrofit)
    implementation(libs.com.squareup.retrofit2.retrofit.converter.gson)
    //Gson
    implementation(libs.com.google.code.gson)
    //http and logging interceptor
    implementation(libs.com.squareup.okhttp3)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)

    //coroutine
    implementation(libs.org.jetbrains.kotlinx.coroutines.core)
    implementation(libs.org.jetbrains.kotlinx.coroutines.android)

    //room
    implementation(libs.androidx.room.room.runtime)
    implementation(libs.androidx.room.room.ktx)
    kapt(libs.androidx.room.room.compiler)

    //dagger
//    implementation(libs.com.google.dagger)
//    implementation(libs.com.google.dagger.compiler)

    //#glide
    implementation(libs.com.github.bumptech.glide)
    annotationProcessor(libs.com.github.bumptech.glide.compiler)

//    #Hilt
    implementation(libs.com.google.dagger.hilt.android)
    kapt(libs.com.google.dagger.hilt.android.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
import dependencies.Dep

plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation(Dep.AndroidX.design)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.viewModelKtx)
    implementation(Dep.AndroidX.activityKtx)
    implementation(Dep.Kotlin.coroutines)
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.batch.kmm_sample_app.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures.viewBinding = true
}
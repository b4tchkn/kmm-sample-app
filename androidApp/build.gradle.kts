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
    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.uiTooling)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Coil.coil)
    implementation(Dep.Coil.base)
    implementation(Dep.Kodein.kodeinDiAndroidX)
    implementation(kotlin("script-runtime"))
}

android {
    compileSdk = 30
    defaultConfig {
        applicationId = "com.batch.kmm_sample_app.androidApp"
        minSdk = 24
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
}
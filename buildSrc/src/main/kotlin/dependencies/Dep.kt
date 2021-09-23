package dependencies

object Dep {
    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val design = "com.google.android.material:material:1.4.0"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
        const val activityKtx = "androidx.activity:activity-ktx:1.1.0"

        object Compose {
            const val ui = "androidx.compose.ui:ui:1.0.2"
            const val material = "androidx.compose.material:material:1.0.2"
            const val uiTooling = "androidx.compose.ui:ui-tooling:1.0.2"
        }
    }

    object Kotlin {
        const val androidCoroutinesDispatcher =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-native-mt"
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.2"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
    }

    object Ktor {
        const val client = "io.ktor:ktor-client-core:1.6.3"
        const val clientAndroid = "io.ktor:ktor-client-okhttp:1.6.3"
        const val clientIos = "io.ktor:ktor-client-ios:1.6.3"
        const val serialization = "io.ktor:ktor-client-serialization:1.6.3"
    }

    object SqlDelight {
        const val runtime = "com.squareup.sqldelight:runtime:1.4.4"
        const val androidDriver = "com.squareup.sqldelight:android-driver:1.4.4"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:1.4.4"
        const val coroutinesExtensions = "com.squareup.sqldelight:coroutines-extensions:1.4.4"
    }

    object Coil {
        const val coil = "io.coil-kt:coil:1.1.0"
        const val base = "io.coil-kt:coil-base:1.1.0"
    }

    object Kodein {
        const val kodeinDi = "org.kodein.di:kodein-di:7.8.0"
        const val kodeinDiAndroidX = "org.kodein.di:kodein-di-framework-android-x:7.8.0"
    }

    object Test {
        const val junit = "junit:junit:4.13.1"
    }
}
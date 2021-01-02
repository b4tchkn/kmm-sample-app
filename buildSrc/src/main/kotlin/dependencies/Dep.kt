package dependencies

object Dep {
    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val design = "com.google.android.material:material:1.2.1"
    }

    object Kotlin {
        const val androidCoroutinesDispatcher = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9-native-mt"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC"
    }

    object Ktor {
        const val client = "io.ktor:ktor-client-core:1.4.0"
        const val clientAndroid = "io.ktor:ktor-client-okhttp:1.4.0"
        const val clientIos = "io.ktor:ktor-client-ios:1.4.0"
        const val serialization = "io.ktor:ktor-client-serialization:1.4.0"
    }

    object SqlDelight {
        const val runtime = "com.squareup.sqldelight:runtime:1.4.4"
        const val androidDriver = "com.squareup.sqldelight:android-driver:1.4.4"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:1.4.4"
    }

    object Test {
        const val junit = "junit:junit:4.13.1"

    }
}
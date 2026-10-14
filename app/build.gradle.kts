plugins {
    id("com.android.application")
}

android {
    namespace = "br.com.gyema"
    compileSdk = 37

    defaultConfig {
        applicationId = "br.com.gyema"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

buildscript {
    dependencies {
        classpath (libs.androidx.navigation.safe.args.gradle.plugin)
    }
}
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")

}

android {
    namespace = "com.levojuk.countries"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.levojuk.countries"
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
    buildFeatures{
        dataBinding = true
        viewBinding = true
    }

}
val lifeCycleExtensionVersion = "1.1.1"
val supportVersion = "28.0.0"
val retrofitVersion = "2.9.0"
val glideVersion = "4.9.0"
val rxJavaVersion = "2.2.9"
val roomVersion = "2.6.1"
val navVersion = "2.7.7"
val preferencesVersion = "1.1.0"

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.extensionss)
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.legacy.support.v4)
    kapt (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)
    implementation (libs.material)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.adapter.rxjava2)
    implementation (libs.glide)
    implementation (libs.palette.v7)
    implementation (libs.design)
    implementation (libs.androidx.preference)

}
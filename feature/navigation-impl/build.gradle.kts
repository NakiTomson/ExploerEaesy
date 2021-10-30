import Libraries.addCommonDependencies
import Libraries.addNavigationFragment

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    addCommonDependencies()
    addNavigationFragment()
    api(project(":feature:navigation"))
    implementation(project(":feature:dashboard-impl"))
}

android {

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileSdkVersion(AndroidSdk.compile)
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}


import Libraries.addCommonDependencies
import Libraries.addHilt
import Libraries.addNavigationFragment

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    addCommonDependencies()
    addNavigationFragment()
//    addHilt()
    implementation(project(":feature-core"))
    api(project(":feature:main"))
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


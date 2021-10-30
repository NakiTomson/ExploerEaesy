import Libraries.addCommonDependencies
import Libraries.addNavigationFragment
import Libraries.addHilt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
//    id("dagger.hilt.android.plugin")
}


android {

    defaultConfig {
        applicationId("com.testtask.exploereaesy")
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode(1)
        versionName("1.0")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileSdkVersion(AndroidSdk.compile)
    compileSdkVersion(30)
    buildToolsVersion ("30.0.3")
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    addCommonDependencies()
//    addHilt()
    addNavigationFragment()
    implementation(project(":core-di"))
    implementation(project(":interactors-impl"))
    implementation(project(":persistence-impl"))
    implementation(project(":repositories-impl"))
    implementation(project(":feature:dashboard-impl"))
    implementation(project(":feature:splash-impl"))
    implementation(project(":feature:navigation-impl"))
    implementation(project(":feature:main-impl"))
}



import Libraries.addCommonDependencies
import Libraries.addHilt

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    addCommonDependencies()
//    addHilt()
    implementation(project(":repositories"))
    implementation(project(":persistence"))
    implementation(project(":interactors"))
    implementation(project(":ui-kit"))
    implementation(project(":feature:main"))
    implementation(project(":feature:navigation"))
    implementation(project(":feature:splash"))
    implementation(project(":feature:dashboard"))
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
}

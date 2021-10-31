import Libraries.addCommonDependencies
import Libraries.addLifeCycler
import Libraries.addNavigationFragment

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    addCommonDependencies()
    addNavigationFragment()
    addLifeCycler()
    api(Libraries.appCompat)
    api(Libraries.fragmentKtx)
    api(Libraries.material)
    api(Libraries.constraintLayout)
    api(Libraries.recyclerView)
    api(Libraries.viewPager2)
    api(Libraries.circleImageView)
    api(Libraries.kohii_core)
    api(Libraries.kohii_exoplayer)
    api(Libraries.swipeRefreshLayout)
    api(Libraries.exoplayer)
    api(Libraries.pinView)
    api(Libraries.decoro)
    debugApi(Libraries.leakCanary)
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



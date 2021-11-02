import Libraries.addCommonDependencies
import Libraries.addNavigationFragment

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    addCommonDependencies()
    addNavigationFragment()
    implementation(project(":feature-core"))
}

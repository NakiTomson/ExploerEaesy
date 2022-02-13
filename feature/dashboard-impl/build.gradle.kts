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
    implementation(project(mapOf("path" to ":network")))
    addCommonDependencies()
    addNavigationFragment()
    implementation(project(":feature-core"))
}

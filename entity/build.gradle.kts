import Libraries.addCommonDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

dependencies {
    addCommonDependencies()
}
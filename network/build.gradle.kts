import Libraries.addCommonDependencies
import Libraries.addNetworkDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

dependencies {
    addCommonDependencies()
    addNetworkDependencies()
    api(project(":entity"))
}
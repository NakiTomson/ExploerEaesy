import Libraries.addCommonDependenciesApi
import Libraries.addCommonUIDependenciesApi
import Libraries.addLifecycleApi
import Libraries.addNavigationFragmentApi

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    addCommonDependenciesApi()
    addNavigationFragmentApi()
    addCommonUIDependenciesApi()
    addLifecycleApi()
    api(project(":entity"))
}

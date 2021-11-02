import Libraries.addCommonDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    addCommonDependencies()
    api(project(":core-ui"))
    api(project(":core-di"))
    api(project(":repositories"))
    api(project(":interactors"))
}

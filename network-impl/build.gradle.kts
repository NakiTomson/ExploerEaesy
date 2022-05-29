import Libraries.addCommonDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

dependencies {
    addCommonDependencies()
    api(project(":network"))
    implementation(project(":core-di"))
    debugApi(Libraries.chucker)
    implementation(project(":persistence"))
}
import Libraries.addCommonDependencies
import Libraries.addRoom

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    addCommonDependencies()
    addRoom()
    api(project(":persistence"))
    implementation(project(":core-di"))
}
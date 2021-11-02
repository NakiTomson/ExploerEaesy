import Libraries.addCommonDependencies
import Libraries.addRoom

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    addRoom()
    addCommonDependencies()
    api(project(":entity"))
}
import Libraries.addCommonDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}


dependencies {
    addCommonDependencies()
    api(project(":entity"))
    api(project(":persistence"))
    implementation(project(":network"))
}
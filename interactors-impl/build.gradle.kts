import Libraries.addCommonDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}


dependencies {
    addCommonDependencies()
    api(project(":interactors"))
    implementation(project(":core-di"))
    implementation(project(":repositories"))
}

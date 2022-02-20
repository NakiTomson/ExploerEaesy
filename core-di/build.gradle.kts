import Libraries.addCommonDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    addCommonDependencies()
    implementation(project(":repositories"))
    implementation(project(":persistence"))
    implementation(project(":interactors"))
    implementation(project(":entity"))
    implementation(project(":ui-kit"))
    implementation(project(":network"))
    implementation(project(":feature:base"))
}

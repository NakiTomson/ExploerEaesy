import Libraries.addCommonDependencies
import Libraries.addNavigationFragment

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

dependencies {
    addCommonDependencies()
    addNavigationFragment()
    implementation(project(":feature-core"))
    api(project(":feature:base"))

}
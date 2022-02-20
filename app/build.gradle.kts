import AndroidSdk.applicationId
import AndroidSdk.versionName
import Libraries.addCommonDependencies
import Libraries.addNavigationFragment


plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
//    id("dagger.hilt.android.plugin")
}


android {
    defaultConfig {
        applicationId = AndroidSdk.applicationId
        versionCode = AndroidSdk.verstionCode
        versionName = AndroidSdk.versionName
    }
}

dependencies {
    addCommonDependencies()
    addNavigationFragment()
    implementation(project(":core-di"))
    implementation(project(":core-ui"))
    implementation(project(":network-impl"))
    implementation(project(":interactors-impl"))
    implementation(project(":persistence-impl"))
    implementation(project(":repositories-impl"))
    implementation(project(":feature:dashboard-impl"))
    implementation(project(":feature:splash-impl"))
    implementation(project(":feature:navigation-impl"))
    implementation(project(":feature:home-impl"))
    implementation(project(":feature:user-impl"))
    implementation(project(":feature:base-impl"))
}



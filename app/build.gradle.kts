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
    flavorDimensions("default")

    defaultConfig {
        applicationId = AndroidSdk.applicationId
        versionCode = AndroidSdk.verstionCode
        versionName = AndroidSdk.versionName
    }

    applicationVariants.all {
        outputs.forEach { output ->
            if (output is com.android.build.gradle.internal.api.BaseVariantOutputImpl) {
                output.outputFileName = "${applicationId}.${versionName}-(${versionCode})-${buildType.name}.${output.outputFile.extension}"
            }
        }
    }

    buildTypes {

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isShrinkResources = false
            isMinifyEnabled = false
        }

        productFlavors {
            create("dev") {
                dimension = "default"
                buildConfigField("String", "BASE_URL", "\"https://61881fc2057b9b00177f9bc2.mockapi.io\"")
                buildConfigField("String", "DATA_BASE_NAME", "\"explodereas.db\"")
            }
        }
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



import Libraries.addCommonDependencies
import Libraries.addRoom

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    defaultConfig {
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }
    sourceSets {
        getByName("androidTest").assets.srcDir("$projectDir/schemas")
    }
}
dependencies {
    addCommonDependencies()
    addRoom()
    api(project(":persistence"))
    implementation(project(":core-di"))
    implementation(project(":network"))
}
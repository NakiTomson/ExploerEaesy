buildscript {
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.navigationGradlePlugin)
        classpath(BuildPlugins.navigationGradlePlugin)
    }
}


plugins {
    kotlin("android") version kotlinVersion apply false
}


subprojects {

    @Suppress("DEPRECATION") // Alternative is to do it for each android plugin id.
    plugins.withType(com.android.build.gradle.BasePlugin::class.java).configureEach {
        project.extensions.getByType<com.android.build.gradle.BaseExtension>().apply {
            compileSdkVersion(AndroidSdk.compile)
            defaultConfig {
                minSdkVersion(AndroidSdk.min)
                targetSdkVersion(AndroidSdk.target)
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

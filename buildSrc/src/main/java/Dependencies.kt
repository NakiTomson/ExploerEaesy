@file:Suppress("MemberVisibilityCanBePrivate", "SpellCheckingInspection")

import org.gradle.api.artifacts.dsl.DependencyHandler

const val kotlinVersion = "1.4.31"
const val hiltVersion = "2.33-beta"

object AndroidSdk {

    const val min = 21
    const val compile = 30
    const val target = compile
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.1.2"
        const val googleServicesVersion = "4.3.4"
        const val appdistributionVersion = "2.0.1"
        const val crashlyticsVersion = "2.3.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val navigationGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${hiltVersion}"
    const val googleServicesGradlePlugin = "com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val appdistributionGradlePlugin =
        "com.google.firebase:firebase-appdistribution-gradle:${Versions.appdistributionVersion}"
    const val crashlyticsGradlePlugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsVersion}"
}

object Libraries {

    object Versions {

        const val hilt ="2.40"
        const val coroutines = "1.4.3"

        const val appCompat = "1.3.0"
        const val fragment = "1.3.4"
        const val navigation = "2.3.2"
        const val coreKtx = "1.5.0"

        const val dagger = "2.40"
        const val assistedInject = "0.5.2"


        const val lifecycle = "2.3.1"

        const val material = "1.3.0"
        const val constraintLayout = "2.0.4"
        const val recyclerView = "1.1.0"
        const val viewPager2 = "1.0.0"
        const val circleImageView = "3.1.0"

        const val simplifySpan = "2.1"

        const val fastAdapter = "5.2.2"

        const val leakCanary = "2.4"
        const val chucker = "3.4.0"

        const val glide = "4.11.0"

        const val simpleCropView = "1.1.8"

        const val junit = "4.12"
        const val androidTestJunit = "1.1.0"
        const val espresso = "3.2.0"

        const val retrofit = "2.9.0"
        const val okhttp3 = "3.8.0"
        const val logging_interceptor = "4.8.1"

        const val security_crypto = "1.1.0-alpha02"

        const val pinView = "1.4.3"
        const val decoro = "1.4.1"
        const val kohii = "1.1.1.2011003"
        const val exoplayer = "2.10.4"

        const val places = "2.4.0"
        const val placesServices = "17.0.0"

        const val camerax = "1.0.0-beta12"
        const val camerax_view = "1.0.0-alpha19"

        const val photoEditor = "1.1.0"

        const val photoCompressor = "3.0.1"

        const val firebaseBom = "26.1.1"

        const val swipeRefreshLayout = "1.0.0"

        const val sentry = "4.0.0"


        const val segmentedButton = "2.0.2"

        const val stateMachine = "0.2.0"

        const val palette = "1.0.0"

        const val blurry = "4.0.0"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"


    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val assistedInjectAnnotations = "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.assistedInject}"
    const val assistedInjectProcessor = "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.assistedInject}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:1.0.0"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"


    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"

    const val simplifyspan = "com.github.iwgang:simplifyspan:${Versions.simplifySpan}"

    const val fastAdapter = "com.mikepenz:fastadapter:${Versions.fastAdapter}"
    const val fastadapterExpandable = "com.mikepenz:fastadapter-extensions-expandable:${Versions.fastAdapter}"
    const val fastadapterDiff = "com.mikepenz:fastadapter-extensions-diff:${Versions.fastAdapter}"
    const val fastadapterDrag = "com.mikepenz:fastadapter-extensions-drag:${Versions.fastAdapter}"
    const val fastadapterPaged = "com.mikepenz:fastadapter-extensions-paged:${Versions.fastAdapter}"
    const val fastadapterScroll = "com.mikepenz:fastadapter-extensions-scroll:${Versions.fastAdapter}"
    const val fastadapterSwipe = "com.mikepenz:fastadapter-extensions-swipe:${Versions.fastAdapter}"
    const val fastadapterUI = "com.mikepenz:fastadapter-extensions-ui:${Versions.fastAdapter}"
    const val fastadapterUtils = "com.mikepenz:fastadapter-extensions-utils:${Versions.fastAdapter}"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val simpleCropView = "com.isseiaoki:simplecropview:${Versions.simpleCropView}"

    const val junit = "junit:junit:${Versions.junit}"
    const val androidTestJunit = "androidx.test.ext:junit:${Versions.androidTestJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    const val security_crypto = "androidx.security:security-crypto:${Versions.security_crypto}"

    const val pinView = "com.chaos.view:pinview:${Versions.pinView}"
    const val decoro = "ru.tinkoff.decoro:decoro:${Versions.decoro}"

    const val kohii_core = "im.ene.kohii:kohii-core:${Versions.kohii}"
    const val kohii_exoplayer = "im.ene.kohii:kohii-exoplayer:${Versions.kohii}"
    const val exoplayer = "com.google.android.exoplayer:exoplayer:${Versions.exoplayer}"

    const val places = "com.google.android.libraries.places:places:${Versions.places}"

    const val placesServices = "com.google.android.gms:play-services-places:${Versions.placesServices}"

    const val photoEditor = "ja.burhanrashid52:photoeditor:${Versions.photoEditor}"

    const val photoCompressor = "id.zelory:compressor:${Versions.photoCompressor}"

    const val camerax = "androidx.camera:camera-camera2:${Versions.camerax}"
    const val camerax_lifecycle = "androidx.camera:camera-lifecycle:${Versions.camerax}"
    const val camerax_core = "androidx.camera:camera-core:${Versions.camerax}"
    const val camerax_view = "androidx.camera:camera-view:${Versions.camerax_view}"
    const val camerax_ext = "androidx.camera:camera-extensions:${Versions.camerax_view}"

    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"

    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"


    const val firebaseMessaging = "com.google.firebase:firebase-messaging"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics"

    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    const val sentry = "io.sentry:sentry-android:${Versions.sentry}"

    const val segmentedButton = "com.github.ceryle:SegmentedButton:v${Versions.segmentedButton}"

    const val stateMachine = "com.tinder.statemachine:statemachine:${Versions.stateMachine}"

    const val palette = "androidx.palette:palette:${Versions.palette}"

    const val blurry = "jp.wasabeef:blurry:${Versions.blurry}"


    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    const val navigationFragmentRuntime = "androidx.navigation:navigation-runtime:${Versions.navigation}"
    const val navigationFragmentRuntimektx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmenktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi= "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationUiktx= "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationDynamic= "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"



    fun DependencyHandler.addNavigationFragment() {
        implementation(fragment)
        implementation(fragmentKtx)
        implementation(navigationFragmentRuntime)
        implementation(navigationFragmentRuntime)
        implementation(navigationFragmentRuntimektx)
        implementation(navigationFragment)
        implementation(navigationFragmenktx)
        implementation(navigationUi)
        implementation(navigationUiktx)
        implementation(navigationDynamic)
    }


    fun DependencyHandler.addCommonDependencies() {
        implementation(kotlin)
        implementation(coroutines)
        implementation(coroutines_android)
        implementation(coreKtx)
        implementation(dagger)
        add("kapt", daggerCompiler)
        add("compileOnly", assistedInjectAnnotations)
        add("kapt", assistedInjectProcessor)
        implementation(glide)
        add("kapt", glideCompiler)
        implementation(material)
    }

    fun DependencyHandler.addHilt() {
        implementation(hilt)
        implementation(hiltNavigation)
        add("kapt", hiltCompiler)
    }

    fun DependencyHandler.addFastAdapterDependencies() {
        api(fastAdapter)
        api(fastadapterDiff)
        api(fastadapterExpandable)
        api(fastadapterDrag)
        api(fastadapterPaged)
        api(fastadapterScroll)
        api(fastadapterSwipe)
        api(fastadapterUtils)
        api(fastadapterUI)
    }

    fun DependencyHandler.addNetworkDependencies() {
        api(retrofit)
        api(retrofitConverterGson)
        api(okhttp3)
        api(logging_interceptor)

    }

    fun DependencyHandler.addCameraDependencies() {
        implementation(camerax)
        implementation(camerax_core)
        implementation(camerax_ext)
        implementation(camerax_lifecycle)
        implementation(camerax_view)
    }

    fun DependencyHandler.addStateMachine() {
        implementation(stateMachine)
    }

    fun DependencyHandler.addFirebaseMessaging() {
        implementation(platform(firebaseBom))
        implementation(firebaseMessaging)
    }

    private fun DependencyHandler.api(depName: String) {
        add("api", depName)
    }

    private fun DependencyHandler.implementation(depName: Any) {
        add("implementation", depName)
    }

    private fun DependencyHandler.kapt(depName: Any) {
        add("kapt", depName)
    }
}
@file:Suppress("MemberVisibilityCanBePrivate", "SpellCheckingInspection")

import org.gradle.api.artifacts.dsl.DependencyHandler

const val kotlinVersion = "1.6.10"

object AndroidSdk {
    const val applicationId = "com.testtask.exploereaesy"
    const val verstionCode = 1
    const val versionName = "1.0"
    const val min = 21
    const val compile = 31
    const val target = compile
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "7.0.0"
        const val googleServicesVersion = "4.3.4"
        const val appdistributionVersion = "2.0.1"
        const val crashlyticsVersion = "2.3.0"
        const val navigationVersion = "2.4.0-alpha10"
        const val hiltVersion = "2.33-beta"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val navigationGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val googleServicesGradlePlugin = "com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val appdistributionGradlePlugin =
        "com.google.firebase:firebase-appdistribution-gradle:${Versions.appdistributionVersion}"
    const val crashlyticsGradlePlugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsVersion}"
}

object Libraries {

    object Versions {
        const val dagger = "2.40"
        const val daggerCompiler = "2.40"
        const val hilt = "2.40"
        const val coroutines = "1.4.3"
        const val appCompat = "1.3.0"
        const val fragment = "1.3.4"
        const val navigation = "2.4.0-alpha10"
        const val coreKtx = "1.5.0"
        const val lifecycle = "2.4.0"
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
        const val room = "2.4.2"
    }

    //Kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    //Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerCompiler}"

    //Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:1.0.0"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    //LifeCycler ViewModel
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val composeLifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
    const val lifecycleReactivestreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycle}"

    //MetraiDisign Ui
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    //FastAdapter
    const val fastAdapter = "com.mikepenz:fastadapter:${Versions.fastAdapter}"
    const val fastadapterExpandable = "com.mikepenz:fastadapter-extensions-expandable:${Versions.fastAdapter}"
    const val fastadapterDiff = "com.mikepenz:fastadapter-extensions-diff:${Versions.fastAdapter}"
    const val fastadapterDrag = "com.mikepenz:fastadapter-extensions-drag:${Versions.fastAdapter}"
    const val fastadapterPaged = "com.mikepenz:fastadapter-extensions-paged:${Versions.fastAdapter}"
    const val fastadapterScroll = "com.mikepenz:fastadapter-extensions-scroll:${Versions.fastAdapter}"
    const val fastadapterSwipe = "com.mikepenz:fastadapter-extensions-swipe:${Versions.fastAdapter}"
    const val fastadapterUI = "com.mikepenz:fastadapter-extensions-ui:${Versions.fastAdapter}"
    const val fastadapterUtils = "com.mikepenz:fastadapter-extensions-utils:${Versions.fastAdapter}"

    //Fragment
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val navigationFragmentRuntime = "androidx.navigation:navigation-runtime:${Versions.navigation}"
    const val navigationFragmentRuntimektx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmenktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationUiktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    //Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKts = "androidx.room:room-ktx:${Versions.room}"
    const val roomRxJava = "androidx.room:room-rxjava2:${Versions.room}"

    //NetWork
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    //Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val androidTestJunit = "androidx.test.ext:junit:${Versions.androidTestJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    //Playments
    const val pinView = "com.chaos.view:pinview:${Versions.pinView}"
    const val decoro = "ru.tinkoff.decoro:decoro:${Versions.decoro}"

    //Video
    const val kohii_core = "im.ene.kohii:kohii-core:${Versions.kohii}"
    const val kohii_exoplayer = "im.ene.kohii:kohii-exoplayer:${Versions.kohii}"
    const val exoplayer = "com.google.android.exoplayer:exoplayer:${Versions.exoplayer}"

    //Camera
    const val camerax = "androidx.camera:camera-camera2:${Versions.camerax}"
    const val camerax_lifecycle = "androidx.camera:camera-lifecycle:${Versions.camerax}"
    const val camerax_core = "androidx.camera:camera-core:${Versions.camerax}"
    const val camerax_view = "androidx.camera:camera-view:${Versions.camerax_view}"
    const val camerax_ext = "androidx.camera:camera-extensions:${Versions.camerax_view}"
    const val photoEditor = "ja.burhanrashid52:photoeditor:${Versions.photoEditor}"
    const val photoCompressor = "id.zelory:compressor:${Versions.photoCompressor}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val simpleCropView = "com.isseiaoki:simplecropview:${Versions.simpleCropView}"

    //FireBase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics"

    //Other
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val places = "com.google.android.libraries.places:places:${Versions.places}"
    const val placesServices = "com.google.android.gms:play-services-places:${Versions.placesServices}"
    const val segmentedButton = "com.github.ceryle:SegmentedButton:v${Versions.segmentedButton}"
    const val stateMachine = "com.tinder.statemachine:statemachine:${Versions.stateMachine}"
    const val palette = "androidx.palette:palette:${Versions.palette}"
    const val blurry = "jp.wasabeef:blurry:${Versions.blurry}"
    const val simplifyspan = "com.github.iwgang:simplifyspan:${Versions.simplifySpan}"
    const val security_crypto = "androidx.security:security-crypto:${Versions.security_crypto}"


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

    fun DependencyHandler.addNavigationFragmentApi() {
        api(fragment)
        api(fragmentKtx)
        api(navigationFragmentRuntime)
        api(navigationFragmentRuntime)
        api(navigationFragmentRuntimektx)
        api(navigationFragment)
        api(navigationFragmenktx)
        api(navigationUi)
        api(navigationUiktx)
        api(navigationDynamic)
    }

    fun DependencyHandler.addRoom() {
        implementation(room)
        implementation(roomKts)
        implementation(roomRxJava)
        kapt(roomCompiler)
    }

    fun DependencyHandler.addLifecycleApi() {
//        implementation(composeLifecycle)
        api(lifecycleRuntime)
        api(lifecycleKtx)
//        implementation(lifecycleJava8)
//        implementation(lifecycleService)
//        implementation(lifecycleProcess)
//        implementation(lifecycleReactivestreams)
        kapt(lifecycleCompiler)
    }

    fun DependencyHandler.addViewModel() {
        implementation(viewModelKtx)
        implementation(viewModelSavedState)
    }

    fun DependencyHandler.addCommonDependencies() {
        implementation(kotlin)
        implementation(coroutines)
        implementation(coroutines_android)
        implementation(coreKtx)
        implementation(dagger)
        implementation(glide)
        implementation(material)
        kapt(daggerCompiler)
        kapt(glideCompiler)
    }

    fun DependencyHandler.addCommonDependenciesApi() {
        api(kotlin)
        api(coroutines)
        api(coroutines_android)
        api(coreKtx)
        api(dagger)
        api(glide)
        api(material)
        kapt(daggerCompiler)
        kapt(glideCompiler)
    }

    fun DependencyHandler.addCommonUIDependenciesApi() {
        api(appCompat)
        api(fragmentKtx)
        api(material)
        api(constraintLayout)
        api(recyclerView)
        api(viewPager2)
        api(circleImageView)
        api(kohii_core)
        api(kohii_exoplayer)
        api(swipeRefreshLayout)
        api(exoplayer)
        api(pinView)
        api(decoro)
        debugApi(leakCanary)
    }


    fun DependencyHandler.addHilt() {
        implementation(hilt)
        implementation(hiltNavigation)
        kapt(hiltCompiler)
    }


    fun DependencyHandler.addNetworkDependencies() {
        api(retrofit)
        api(retrofitConverterGson)
        api(okhttp3)
        api(logging_interceptor)
    }
}

private fun DependencyHandler.api(depName: String) = add("api", depName)
private fun DependencyHandler.implementation(depName: Any) = add("implementation", depName)
private fun DependencyHandler.kapt(depName: Any) = add("kapt", depName)
private fun DependencyHandler.compileOnly(depName: Any) = add("compileOnly", depName)
private fun DependencyHandler.debugApi(dependencyNotation: Any) = add("debugApi", dependencyNotation)

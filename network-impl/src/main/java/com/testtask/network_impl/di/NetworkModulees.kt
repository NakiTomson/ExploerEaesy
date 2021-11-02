package com.testtask.network_impl.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.testtask.network.BuildConfig
import com.testtask.network.service.ServiceFactory
import com.testtask.network_impl.adapter.ServiceFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Singleton

@Module
interface NetworkModule {


    @Singleton
    @Binds
    fun provideAuthInterceptor(appInterceptor: AppInterceptor): Interceptor

    @Singleton
    @Binds
    fun provideServiceClient(serviceFactoryImpl: ServiceFactoryImpl): ServiceFactory

    @Module
    companion object {

        private const val httpCacheSizeBytes = 1024 * 1024 * 50L
        private const val connectTimeout = 30000L
        private const val networkTimeout = 10000L

        @JvmStatic
        @Provides
        @Singleton
        fun provideGson(): Gson = GsonBuilder().create()

        @JvmStatic
        @Provides
        @Singleton
        fun httpCache(context: Context): Cache = Cache(context.cacheDir, httpCacheSizeBytes)


        @JvmStatic
        @Provides
        @Singleton
        fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else level
        }

        @JvmStatic
        @Singleton
        @Provides
        fun provideOkHttpClient(
            context: Context,
            cache: Cache,
            authInterceptor: Interceptor,
            loggingInterceptor: HttpLoggingInterceptor
        ): OkHttpClient.Builder {
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder
                .connectTimeout(connectTimeout, MILLISECONDS)
                .readTimeout(networkTimeout, MILLISECONDS)
                .writeTimeout(networkTimeout, MILLISECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .followSslRedirects(true)
                .cache(cache)
                .addInterceptor(ChuckerInterceptor(context))
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
            return okHttpClientBuilder
        }
    }

}
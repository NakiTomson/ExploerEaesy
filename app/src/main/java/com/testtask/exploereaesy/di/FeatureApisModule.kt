package com.testtask.exploereaesy.di

import com.testtask.main.MainFeatureApi
import com.testtask.main_impl.MainFeatureApiImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureApisModule {


    @Binds
    fun bindsMainFeatureApi(impl: MainFeatureApiImpl): MainFeatureApi
}
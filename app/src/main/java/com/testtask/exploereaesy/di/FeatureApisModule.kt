package com.testtask.exploereaesy.di


import com.example.base.BaseFeatureApi
import com.example.base_impl.BaseFeatureApiImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureApisModule {

    @Binds
    fun bindsFeatureBaseApi(impl: BaseFeatureApiImpl): BaseFeatureApi
}
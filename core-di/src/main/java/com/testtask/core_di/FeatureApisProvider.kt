package com.testtask.core_di

import com.example.base.BaseFeatureApi

interface FeatureApisProvider {
    fun provideFeaturesBaseApi(): BaseFeatureApi
}
package com.testtask.exploereaesy

import android.content.Context
import com.testtask.core_di.configuration.Configuration
import javax.inject.Inject

class ConfigurationImpl @Inject constructor(private val context: Context) : Configuration {

    override val baseUrl: String
        get() = BuildConfig.BASE_URL

    override val appVersionName: String = BuildConfig.VERSION_NAME
    override val appVersionCode: Int = BuildConfig.VERSION_CODE
    override val dataBaseName: String = BuildConfig.DATA_BASE_NAME
    override val googlePayEnvironment: Int = 0
}
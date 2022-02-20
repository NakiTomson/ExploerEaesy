package com.testtask.core_di.configuration

interface Configuration {

    val baseUrl: String

    val appVersionName: String

    val appVersionCode: Int

    val dataBaseName: String

    val googlePayEnvironment: Int
}
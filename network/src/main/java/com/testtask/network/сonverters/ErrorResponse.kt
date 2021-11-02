package com.testtask.network.сonverters

import okhttp3.ResponseBody
import retrofit2.Retrofit

data class ErrorResponse(val errorResponseBody: ResponseBody?, val url: String, val retrofit: Retrofit?)
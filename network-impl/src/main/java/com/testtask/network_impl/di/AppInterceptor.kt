package com.testtask.network_impl.di

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import javax.inject.Inject

class AppInterceptor @Inject constructor(
) : Interceptor {

    override fun intercept(chain: Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val urlBuilder = request.url.newBuilder()
        builder.apply {
            url(urlBuilder.build())
        }
        return processingResponse(chain.proceed(builder.build()))
    }

    private fun processingResponse(response: Response): Response {
        return response
    }
}

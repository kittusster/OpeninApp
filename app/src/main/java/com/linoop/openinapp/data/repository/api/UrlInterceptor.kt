package com.linoop.openinapp.data.repository.api

import com.linoop.openinapp.utils.Constants.ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class UrlInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
       val request = chain.request().newBuilder()
        request.header("Authorization", "Bearer $ACCESS_TOKEN")
        return chain.proceed(request.build())
    }
}
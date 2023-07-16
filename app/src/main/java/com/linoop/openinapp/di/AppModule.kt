package com.linoop.openinapp.di

import com.linoop.openinapp.business.GetDashboardDataUseCase
import com.linoop.openinapp.business.OpenInRepo
import com.linoop.openinapp.data.repository.OpenInRepoImpl
import com.linoop.openinapp.data.repository.api.Api
import com.linoop.openinapp.data.repository.api.UrlInterceptor
import com.linoop.openinapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Api =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
            .create(Api::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

    @Singleton
    @Provides
    fun provideUrlInterceptor(): Interceptor = UrlInterceptor()

    @Provides
    fun provideDashboardDataUseCase(openInRepo: OpenInRepo): GetDashboardDataUseCase =
        GetDashboardDataUseCase(openInRepo)

    @Provides
    fun provideOpenInRepo(api: Api): OpenInRepo = OpenInRepoImpl(api)

}
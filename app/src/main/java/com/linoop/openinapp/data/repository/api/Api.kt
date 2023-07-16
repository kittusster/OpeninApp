package com.linoop.openinapp.data.repository.api

import com.linoop.openinapp.data.DashboardData
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("dashboardNew")
    suspend fun getDashboardData():Response<DashboardData>
}
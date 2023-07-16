package com.linoop.openinapp.data.repository

import com.linoop.openinapp.business.OpenInRepo
import com.linoop.openinapp.data.DashboardData
import com.linoop.openinapp.data.repository.api.Api
import javax.inject.Inject

class OpenInRepoImpl @Inject constructor(private val api: Api):OpenInRepo {
    override suspend fun getDashboardData(): DashboardData {
        return api.getDashboardData().body()!!
    }
}
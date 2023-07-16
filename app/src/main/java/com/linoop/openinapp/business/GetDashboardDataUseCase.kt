package com.linoop.openinapp.business

import com.linoop.openinapp.data.DashboardData
import com.linoop.openinapp.utils.Resource
import javax.inject.Inject

class GetDashboardDataUseCase @Inject constructor(private val openInRepo: OpenInRepo) {
    suspend fun invoke(): Resource<DashboardData> {
        val result = openInRepo.getDashboardData()
        return if (result.status) Resource.Success(result) else Resource.Error("No data available")
    }
}
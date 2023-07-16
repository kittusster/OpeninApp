package com.linoop.openinapp.business

import com.linoop.openinapp.data.DashboardData

interface OpenInRepo {
    suspend fun getDashboardData(): DashboardData
}
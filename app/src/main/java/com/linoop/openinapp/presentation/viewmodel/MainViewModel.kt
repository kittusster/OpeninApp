package com.linoop.openinapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linoop.openinapp.business.GetDashboardDataUseCase
import com.linoop.openinapp.data.DashboardData
import com.linoop.openinapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDashboardDataUseCase: GetDashboardDataUseCase
) : ViewModel() {

    private val _getData = MutableLiveData<Resource<DashboardData>>()
    val getData: LiveData<Resource<DashboardData>> get() = _getData

    init {
        getDashboardData()
    }

    private fun getDashboardData() = viewModelScope.launch {
        _getData.postValue( Resource.Loading())
        _getData.postValue(getDashboardDataUseCase.invoke())
    }
}
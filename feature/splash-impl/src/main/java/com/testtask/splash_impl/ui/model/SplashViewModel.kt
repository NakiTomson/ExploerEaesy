package com.testtask.splash_impl.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _stopSplashLiveData:MutableLiveData<Unit> = MutableLiveData()
    val stopSplashLiveData:LiveData<Unit> get() = _stopSplashLiveData

    private val _openDashBoardLiveData:MutableLiveData<Unit> = MutableLiveData()
    val openDashBoardLiveData:LiveData<Unit> get() = _stopSplashLiveData

    init {
        updateApp()
    }

    private fun updateApp() {
        viewModelScope.launch {
            delay(2000)
            _stopSplashLiveData.value = null
            _openDashBoardLiveData.value = null
        }
    }
}
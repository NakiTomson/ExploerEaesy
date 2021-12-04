package com.testtask.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), CoroutineScope {

    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, throwable -> handleError(throwable) }

    override val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    protected fun handleError(throwable: Throwable) {
    }

    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}
package com.testtask.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    final override val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    abstract val state: Flow<BaseState?>

    abstract val event: Flow<BaseEvent?>

    init {
        viewModelScope.coroutineContext.plus(this.coroutineContext)
    }

    protected fun handleError(throwable: Throwable) {
    }


    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}
package com.testtask.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    private val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    abstract val event: Flow<BaseEvent?>

    protected val CoroutineScope.launch: (block: suspend CoroutineScope.() -> Unit) -> Job
        get() = { viewModelScope.launch(this@BaseViewModel.coroutineContext) { it.invoke(this) } }

    protected fun handleError(throwable: Throwable) {
    }


    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}
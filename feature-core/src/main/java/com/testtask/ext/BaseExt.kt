package com.testtask.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.testtask.base.BaseFragment
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


fun <T : BaseViewModel> BaseFragment<T>.subscribeState(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    vm: suspend T.() -> Unit,
) {
    viewModel.apply {
        lifecycleScope.launch(coroutineContext) {
            lifecycle.repeatOnLifecycle(state) {
                vm.invoke(this@apply)
            }
        }
    }
}


fun <T> BaseViewModel.into(liveResult: MutableStateFlow<T>, block: suspend () -> T) {
    launch {
        try {
            liveResult.value = block()
        } catch (e: Exception) {
            throw e
        }
    }
}

fun <T> BaseViewModel.sendEvent(liveResult: SingleLiveEventFlow<T>) {
    launch {
        try {
            liveResult.call()
        } catch (e: Exception) {
            throw e
        }
    }
}

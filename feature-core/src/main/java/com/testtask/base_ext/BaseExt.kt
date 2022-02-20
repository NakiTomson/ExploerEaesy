package com.testtask.base_ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseBottomSheetDialogFragment
import com.testtask.base.BaseEvent
import com.testtask.base.BaseFragment
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


fun <T : BaseViewModel> BaseFragment<T>.subscribeState(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = this.coroutineContext,
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


fun <VM : BaseViewModel> BaseFragment<VM>.subscribeEvent(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = this.coroutineContext,
    vm: suspend BaseEvent?.() -> Unit,
) {
    viewModel.event.apply {
        lifecycleScope.launch(coroutineContext) {
            lifecycle.repeatOnLifecycle(state) {
                onEach {
                    vm.invoke(it)
                }.launchIn(lifecycleScope)
            }
        }
    }
}

fun <T : BaseViewModel> BaseBottomSheetDialogFragment<T>.subscribeState(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = this.coroutineContext,
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

fun <VM : BaseViewModel> BaseBottomSheetDialogFragment<VM>.subscribeEvent(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = this.coroutineContext,
    vm: suspend BaseEvent?.() -> Unit,
) {
    viewModel.event.apply {
        lifecycleScope.launch(coroutineContext) {
            lifecycle.repeatOnLifecycle(state) {
                onEach {
                    vm.invoke(it)
                }.launchIn(lifecycleScope)
            }
        }
    }
}


fun <T> BaseViewModel.into(liveResult: MutableStateFlow<T>, block: suspend () -> T) {
    viewModelScope.launch {
        try {
            liveResult.value = block()
        } catch (e: Exception) {
            throw e
        }
    }
}


fun <T> BaseViewModel.sendEvent(liveResult: SingleLiveEventFlow<T>, block: suspend () -> T) {
    viewModelScope.launch {
        try {
            liveResult.postEvent(block())
        } catch (e: Exception) {
            throw e
        }
    }
}

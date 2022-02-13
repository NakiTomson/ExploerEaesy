package com.testtask.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.testtask.base.BaseEvent
import com.testtask.base.BaseFragment
import com.testtask.base.BaseState
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


//fun <T : BaseViewModel> BaseFragment<T>.subscribeState(
//    state: Lifecycle.State,
//    coroutineContext: CoroutineContext = EmptyCoroutineContext,
//    vm: suspend T.() -> Unit,
//) {
//    viewModel.apply {
//        lifecycleScope.launch(coroutineContext) {
//            lifecycle.repeatOnLifecycle(state) {
//                vm.invoke(this@apply)
//            }
//        }
//    }
//}

//fun <T : BaseViewModel> BaseFragment<T>.subscribeEvent(
//    state: Lifecycle.State,
//    coroutineContext: CoroutineContext = EmptyCoroutineContext,
//    vm: suspend T.() -> Unit,
//) {
//    viewModel.apply {
//        lifecycleScope.launch(coroutineContext) {
//            lifecycle.repeatOnLifecycle(state) {
//                vm.invoke(this@apply)
//            }
//        }
//    }
//}


fun <VM : BaseViewModel> BaseFragment<VM>.subscribeState(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    vm: suspend BaseState?.() -> Unit,
) {
    viewModel.state.apply {
        lifecycleScope.launch(coroutineContext) {
            lifecycle.repeatOnLifecycle(state) {
                onEach {
                    vm.invoke(it)
                }.launchIn(lifecycleScope)
            }
        }
    }
}


fun <VM : BaseViewModel> BaseFragment<VM>.subscribeEvent(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
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
    launch {
        try {
            liveResult.value = block()
        } catch (e: Exception) {
            throw e
        }
    }
}


fun <T> BaseViewModel.sendEvent(liveResult: SingleLiveEventFlow<T>, block: suspend () -> T) {
    launch {
        try {
            liveResult.postEvent(block())
        } catch (e: Exception) {
            throw e
        }
    }
}

package com.testtask.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import com.testtask.utils.InjectingSavedStateViewModelFactory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment<out VM : BaseViewModel>(splashFragment: Int) : Fragment(splashFragment),
    HasDefaultViewModelProviderFactory {

    @Inject
    lateinit var defaultViewModelFactory: dagger.Lazy<InjectingSavedStateViewModelFactory>

    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    abstract val viewModel: VM

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        defaultViewModelFactory.get().create(this, arguments)

    protected fun handleError(throwable: Throwable) {

    }
}

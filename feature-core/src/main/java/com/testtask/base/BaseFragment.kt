package com.testtask.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.testtask.feature_core.InjectingSavedStateViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseFragment<out VM : BaseViewModel>(splashFragment: Int) : Fragment(splashFragment),
    HasDefaultViewModelProviderFactory {

    @Inject
    lateinit var defaultViewModelFactory: dagger.Lazy<InjectingSavedStateViewModelFactory>

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        defaultViewModelFactory.get().create(this, arguments)

    abstract val viewModel: VM

}

package com.testtask.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.testtask.utils.InjectingSavedStateViewModelFactory
import javax.inject.Inject

abstract class BaseBottomSheetDialogFragment<out VM : BaseViewModel>(
    @LayoutRes private val layoutRes: Int
) : BottomSheetDialogFragment(), HasDefaultViewModelProviderFactory {

    @Inject
    lateinit var defaultViewModelFactory: dagger.Lazy<InjectingSavedStateViewModelFactory>

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        defaultViewModelFactory.get().create(this, arguments)

    protected abstract val viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }
}
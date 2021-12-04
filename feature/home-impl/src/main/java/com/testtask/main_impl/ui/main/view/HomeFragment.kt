package com.testtask.main_impl.ui.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.testtask.base.BaseFragment
import com.testtask.feature_core.lazyViewModel
import com.testtask.main_impl.R
import com.testtask.main_impl.di.injector
import com.testtask.main_impl.ui.main.viewmodel.HomeViewModel


class HomeFragment : BaseFragment(R.layout.main_fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apply {

        }
    }

    companion object {
        fun create(): Fragment = HomeFragment()
    }
}
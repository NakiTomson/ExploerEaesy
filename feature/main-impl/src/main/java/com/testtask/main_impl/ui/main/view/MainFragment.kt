package com.testtask.main_impl.ui.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.testtask.feature_core.lazyViewModel
import com.testtask.main_impl.R
import com.testtask.main_impl.di.injector
import com.testtask.main_impl.ui.main.viewmodel.MainViewModel


class MainFragment : Fragment(R.layout.main_fragment_main) {

    private val viewModel: MainViewModel by lazyViewModel { stateHandle ->
       injector.mainViewModel().create(stateHandle)
    }

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
        fun create(): Fragment = MainFragment()
    }
}
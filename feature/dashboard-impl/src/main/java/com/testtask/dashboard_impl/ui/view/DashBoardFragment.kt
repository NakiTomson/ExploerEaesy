package com.testtask.dashboard_impl.ui.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.model.DashBoardViewModel
import com.testtask.feature_core.lazyViewModel
import kotlinx.android.synthetic.main.dashborad_fragment.*

class DashBoardFragment : Fragment(R.layout.dashborad_fragment) {

    private val viewModel: DashBoardViewModel by lazyViewModel { stateHandle ->
        injector.dashBoardViewModel().create(stateHandle)
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

        fun create() = DashBoardFragment()
    }
}
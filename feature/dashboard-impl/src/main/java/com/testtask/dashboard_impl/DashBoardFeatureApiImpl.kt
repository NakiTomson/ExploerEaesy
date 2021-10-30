package com.testtask.dashboard_impl

import androidx.fragment.app.Fragment
import com.testtask.dashboard.DashBoardFeatureApi
import com.testtask.dashboard_impl.ui.view.DashBoardFragment

class DashBoardFeatureApiImpl  : DashBoardFeatureApi{

    override fun getOnBoarding(): Fragment {
        return DashBoardFragment.create()
    }
}
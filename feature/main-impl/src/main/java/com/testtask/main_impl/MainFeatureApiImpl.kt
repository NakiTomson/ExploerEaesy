package com.testtask.main_impl

import androidx.fragment.app.Fragment
import com.testtask.main.MainFeatureApi
import com.testtask.main_impl.ui.main.view.MainFragment
import javax.inject.Inject

class MainFeatureApiImpl @Inject constructor() : MainFeatureApi {
    override fun getMainFragment(): Fragment {
        return MainFragment.create()
    }
}
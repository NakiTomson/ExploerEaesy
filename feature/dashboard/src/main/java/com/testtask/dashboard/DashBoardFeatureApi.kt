package com.testtask.dashboard

import androidx.fragment.app.Fragment

interface DashBoardFeatureApi {

    fun getOnBoarding(): Fragment

    interface Owner {

        fun onCloseOnBoarding()
    }
}
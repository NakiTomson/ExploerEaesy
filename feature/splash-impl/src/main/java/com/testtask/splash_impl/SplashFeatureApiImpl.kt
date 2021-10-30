package com.testtask.splash_impl

import androidx.fragment.app.Fragment
import com.testtask.splash.SplashFeatureApi
import com.testtask.splash_impl.ui.view.SplashFragment

class SplashFeatureApiImpl : SplashFeatureApi {

    override fun getSplash(): Fragment {
        return SplashFragment.create()
    }
}
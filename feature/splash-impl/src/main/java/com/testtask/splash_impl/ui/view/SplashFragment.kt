package com.testtask.splash_impl.ui.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.testtask.splash_impl.R
import com.testtask.splash_impl.ui.model.SplashViewModel

class SplashFragment : Fragment(R.layout.splash_fragment) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel.apply {
            openDashBoardLiveData.observe(viewLifecycleOwner,{
                requireActivity().supportFragmentManager.setFragmentResult(SPLASH_RESULT, bundleOf("dashBoard" to true))
            })
            stopSplashLiveData.observe(viewLifecycleOwner,{
                requireActivity().supportFragmentManager.setFragmentResult(SPLASH_RESULT, bundleOf("splash" to true))
            })
        }
    }

    companion object{
        fun create() = SplashFragment()
        const val SPLASH_FRAGMENT = "SplashFragment"
        const val SPLASH_RESULT = "SplashResult"
    }
}
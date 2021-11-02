package com.testtask.navigation_impl.ui.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.testtask.feature_core.lazyViewModel
import com.testtask.navigation_impl.R
import com.testtask.navigation_impl.di.injector
import com.testtask.navigation_impl.ui.viewModel.NavigationViewModel
import kotlinx.android.synthetic.main.fragment_navigation.*


class NavigationFragment : Fragment(R.layout.fragment_navigation) {

    private var currentNavController: LiveData<NavController>? = null

    private val viewModel: NavigationViewModel by lazyViewModel { stateHandle ->
        injector.viewModelFactory().create(stateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigationBar()
        viewModel.apply {

        }
    }

    private fun setupBottomNavigationBar(){
        val navHost = childFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        val navController = navHost.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    companion object {

        fun create() = NavigationFragment()
    }
}
package com.testtask.navigation_impl.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.testtask.feature_core.lazyViewModel
import com.testtask.navigation_impl.R
import com.testtask.navigation_impl.di.injector
import com.testtask.navigation_impl.setupWithNavController
import com.testtask.navigation_impl.ui.viewModel.NavigationViewModel

class NavigationFragment : Fragment(R.layout.fragment_navigation) {

    private var currentNavController: LiveData<NavController>? = null

    private val viewModel: NavigationViewModel by lazyViewModel { stateHandle ->
        injector.viewModelFactory().create(stateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
        viewModel.apply {

        }
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView =
            view?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navGraphIds = listOf(R.navigation.home)
        val controller = bottomNavigationView?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = activity?.supportFragmentManager!!,
            containerId = R.id.nav_host_container,
            intent = activity?.intent!!
        )
        currentNavController = controller
        bottomNavigationView?.callOnClick()
    }

    companion object {

        fun create() = NavigationFragment()
    }
}
package com.testtask.navigation_impl.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.testtask.navigation_impl.R
import com.testtask.navigation_impl.setupWithNavController

class NavigationFragment : Fragment(R.layout.fragment_navigation) {

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }


    private fun setupBottomNavigationBar() {
        val bottomNavigationView =   view?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
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
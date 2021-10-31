package com.testtask.exploereaesy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.testtask.core_ui.NavigationState
import com.testtask.core_ui.Navigator
import com.testtask.exploereaesy.EasyApp
import com.testtask.exploereaesy.NavigatorController
import com.testtask.exploereaesy.R
import com.testtask.exploereaesy.di.AppComponent

class MainActivity : AppCompatActivity(), Navigator {

    private var navigator = NavigatorController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.activity_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        navigator.navController = navController
    }

    private fun injectDependencies() {
        val appComponent = (application as EasyApp).appProvider as AppComponent
        appComponent.inject(this)
    }

    override fun navigate(state: NavigationState) {
        navigator.navigateToFlow(state)
    }
}
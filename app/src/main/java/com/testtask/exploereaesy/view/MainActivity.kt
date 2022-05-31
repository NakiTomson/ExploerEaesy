package com.testtask.exploereaesy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.testtask.exploereaesy.EasyApp
import com.testtask.exploereaesy.R
import com.testtask.exploereaesy.di.AppComponent

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()
        navController = (supportFragmentManager.findFragmentById(R.id.activity_nav_host) as NavHostFragment).navController
    }

    private fun injectDependencies() {
        val appComponent = (application as EasyApp).appProvider as AppComponent
        appComponent.inject(this)
    }
}
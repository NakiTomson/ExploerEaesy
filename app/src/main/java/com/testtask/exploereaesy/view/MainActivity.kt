package com.testtask.exploereaesy.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testtask.exploereaesy.EaesyApp
import com.testtask.exploereaesy.R
import com.testtask.exploereaesy.di.AppComponent
import com.testtask.main.MainFeatureApi
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainFeatureApi: MainFeatureApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()
        if (savedInstanceState == null) {
            addInitFragment()
        }
    }

    private fun injectDependencies() {
        val appComponent = (application as EaesyApp).appProvider as AppComponent
        appComponent.inject(this)
    }

    private fun addInitFragment() {
        val fragmentMain = mainFeatureApi.getMainFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_nav_host, fragmentMain, TagMain)
            .commit()
    }

    companion object {
        const val TagMain = "TagMain"
    }
}
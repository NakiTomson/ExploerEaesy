package com.testtask.core_ui.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.testtask.core_ui.R

class TabNavController(val navController: NavController)

fun Fragment.findTabNavController(): TabNavController {
    val tabNavHost = parentFragment?.parentFragmentManager?.findFragmentById(R.id.nav_host_container) as? NavHostFragment?
    return TabNavController(tabNavHost?.navController ?: findNavController())
}

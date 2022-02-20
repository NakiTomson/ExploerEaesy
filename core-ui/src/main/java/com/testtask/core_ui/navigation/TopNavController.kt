package com.testtask.core_ui.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.testtask.core_ui.R

class NavControllerTop(val navController: NavController)

fun Fragment.findTopNavController(): NavControllerTop {
    val topLevelHost = requireActivity().supportFragmentManager.findFragmentById(R.id.activity_nav_host) as NavHostFragment?
    return NavControllerTop(topLevelHost?.navController ?: findNavController())
}
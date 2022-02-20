package com.testtask.core_ui.navigation

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.testtask.core_ui.R

val devOptions: NavOptions = navOptions {
    anim {
        enter = R.anim.def_enter_anim
        exit = R.anim.def_exit_anim
        popEnter = R.anim.def_pop_enter_anim
        popExit = R.anim.def_pop_exit_anim
    }
}
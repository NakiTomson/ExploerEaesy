package com.testtask.core_ui.fragment

import androidx.fragment.app.Fragment


inline fun <reified T> Fragment.findListenerByParent(): T? {
    var fragment = this
    while (fragment.parentFragment != null) {
        fragment = fragment.requireParentFragment()
        if ((T::class.java.isInstance(fragment))) {
            return fragment as T
        }
    }
    return if (T::class.java.isInstance(activity)) activity as T? else null
}
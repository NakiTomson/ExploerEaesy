package com.example.user.ui.user.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.user.R
import com.example.user.ui.user.model.UserViewModel
import com.example.user.ui.user.model.UserViewModel.Companion.injector
import com.testtask.utils.lazyViewModel

class UserFragment : Fragment(R.layout.user_fragment_user) {

    private val viewModel: UserViewModel by lazyViewModel { stateHandle ->
        injector.viewModelFactory().create(stateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apply {

        }
    }
}
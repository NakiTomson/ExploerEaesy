package com.example.base_impl.ui.empty.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import com.example.base_impl.R
import com.example.base_impl.di.injector
import com.example.base_impl.ui.empty.viewmodel.EmptyDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.testtask.base.BaseBottomSheetDialogFragment

class EmptyDialogFragment :
    BaseBottomSheetDialogFragment<EmptyDialogViewModel>(R.layout.empty_dialog_fragment) {

    override val viewModel: EmptyDialogViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDialog()
    }


    private fun setUpDialog() {
        dialog?.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheetBehavior.skipCollapsed = true
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    companion object {

        fun create() = EmptyDialogFragment()
    }
}
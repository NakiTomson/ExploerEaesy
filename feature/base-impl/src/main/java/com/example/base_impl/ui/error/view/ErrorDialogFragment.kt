package com.example.base_impl.ui.error.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.base_impl.R
import com.example.base_impl.di.injector
import com.example.base_impl.ui.error.viewmodel.ErrorDialogViewModel
import com.example.controller.ErrorDialogListener
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.testtask.base.BaseBottomSheetDialogFragment
import com.testtask.core_ui.fragment.findListenerByParent
import kotlinx.android.synthetic.main.error_dialog_fragment.*

class ErrorDialogFragment :
    BaseBottomSheetDialogFragment<ErrorDialogViewModel>(R.layout.error_dialog_fragment) {

    override val viewModel: ErrorDialogViewModel by viewModels()

    override fun getTheme(): Int = R.style.BottomSheetDialogBlackoutTheme

    private val errorDialogListener: ErrorDialogListener?
        get() = findListenerByParent()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, 0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpContentContainer()
        setUpUiAction()
        setUpDialog()
    }

    private fun setUpContentContainer() {
        clContainerError.updateLayoutParams {
            height = resources.displayMetrics.heightPixels * 9 / 10
        }
    }

    private fun setUpUiAction() {
        buttonTryAgain.setOnClickListener {
            errorDialogListener?.closeErrorFragment()
            dismiss()
        }
    }

    private fun setUpDialog() {
        dialog?.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomSheetBehavior.skipCollapsed = true
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        dialog?.setOnCancelListener {
            errorDialogListener?.closeErrorFragment()
        }
    }

    companion object {

        fun create() = ErrorDialogFragment()
    }
}
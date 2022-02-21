package com.example.base_impl.ui.empty.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.base_impl.R
import com.example.base_impl.di.injector
import com.example.base_impl.ui.empty.viewmodel.EmptyDialogViewModel
import com.example.controller.EmptyDialogListener
import com.example.params.EmptyDialogParams
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.testtask.base.BaseBottomSheetDialogFragment
import com.testtask.base_ext.subscribeState
import com.testtask.core_ui.fragment.findListenerByParent
import kotlinx.android.synthetic.main.empty_dialog_fragment.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class EmptyDialogFragment :
    BaseBottomSheetDialogFragment<EmptyDialogViewModel>(R.layout.empty_dialog_fragment) {

    override val viewModel: EmptyDialogViewModel by viewModels()

    override fun getTheme(): Int = R.style.BottomSheetDialogBlackoutTheme

    private val emptyDialogListener: EmptyDialogListener?
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
        handlerUiEvent()
        handlerUiState()
    }

    private fun setUpContentContainer() {
        clContainerEmpty.updateLayoutParams {
            height = resources.displayMetrics.heightPixels * 9 / 10
        }
    }

    private fun setUpUiAction() {
        emptyButtonTryAgain.setOnClickListener {
            emptyDialogListener?.closeEmptyFragment()
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
            emptyDialogListener?.closeEmptyFragment()
        }
    }

    private fun handlerUiState() {
        subscribeState(Lifecycle.State.CREATED) {
            paramsEmptyDialog.onEach { params ->
                setEmptyData(params)
            }.launchIn(viewModelScope)
        }
    }

    private fun handlerUiEvent() {

    }

    private fun setEmptyData(emptyDialogParams: EmptyDialogParams) {
        groupEmpty.isVisible = false
        tvNoResultTitle.text = emptyDialogParams.title
        tvNoResultDescription.text = emptyDialogParams.description
        Glide.with(this)
            .load(emptyDialogParams.imageUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    groupEmpty.isVisible = true
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    groupEmpty.isVisible = true
                    return false
                }
            })
            .into(ivEmpty)
    }

    companion object {

        const val ARG_EMPTY_PARAMS = "ARG_EMPTY_PARAMS"
        fun create(params: EmptyDialogParams?) =
            EmptyDialogFragment().apply {
                arguments = bundleOf(
                    ARG_EMPTY_PARAMS to params,
                )
            }

    }
}
package com.example.base

import androidx.fragment.app.FragmentManager
import com.example.params.EmptyDialogParams
import com.example.params.ErrorDialogParams
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BaseFeatureApi {

    fun getErrorDialog(params: ErrorDialogParams? = null): BottomSheetDialogFragment

    fun getEmptyDialog(params: EmptyDialogParams? = null): BottomSheetDialogFragment

    fun showErrorDialogOrClose(isError: Boolean, fragmentManager: FragmentManager)

    fun showEmptyDialogOrClose(isEmpty: Boolean, fragmentManager: FragmentManager)

    companion object {
        const val ERROR_DIALOG_TAG = "ERROR_TAG"
        const val EMPTY_DIALOG_TAG = "ERROR_TAG"
    }
}
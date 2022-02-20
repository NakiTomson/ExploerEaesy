package com.example.base

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BaseFeatureApi {

    fun getErrorDialog(): BottomSheetDialogFragment

    fun getEmptyDialog(): BottomSheetDialogFragment


    companion object {
        const val ERROR_DIALOG_TAG = "ERROR_TAG"
        const val EMPTY_DIALOG_TAG = "ERROR_TAG"
    }
}
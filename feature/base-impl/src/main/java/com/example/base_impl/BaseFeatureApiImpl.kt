package com.example.base_impl

import androidx.fragment.app.FragmentManager
import com.example.base.BaseFeatureApi
import com.example.base_impl.ui.empty.view.EmptyDialogFragment
import com.example.base_impl.ui.error.view.ErrorDialogFragment
import com.example.params.EmptyDialogParams
import com.example.params.ErrorDialogParams
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

class BaseFeatureApiImpl @Inject constructor() : BaseFeatureApi {

    override fun getErrorDialog(params: ErrorDialogParams?) = ErrorDialogFragment.create(params)

    override fun getEmptyDialog(params: EmptyDialogParams?) = EmptyDialogFragment.create(params)

    override fun showErrorDialogOrClose(isError: Boolean, fragmentManager: FragmentManager) {
        fragmentManager.findFragmentByTag(BaseFeatureApi.ERROR_DIALOG_TAG).let {
            if (isError.not()) {
                (it as? BottomSheetDialogFragment)?.dismiss()
                return
            }
            if (it != null) return
        }
        val dialogFragment = getErrorDialog()
        dialogFragment.show(fragmentManager, BaseFeatureApi.ERROR_DIALOG_TAG)
    }

    override fun showEmptyDialogOrClose(isEmpty: Boolean, fragmentManager: FragmentManager) {
        fragmentManager.findFragmentByTag(BaseFeatureApi.EMPTY_DIALOG_TAG).let {
            if (isEmpty.not()) {
                (it as? BottomSheetDialogFragment)?.dismiss()
                return
            }
            if (it != null) return
        }
        val dialogFragment = getEmptyDialog()
        dialogFragment.show(fragmentManager, BaseFeatureApi.EMPTY_DIALOG_TAG)
    }
}
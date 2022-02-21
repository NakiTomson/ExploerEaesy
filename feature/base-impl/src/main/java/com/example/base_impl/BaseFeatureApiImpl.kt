package com.example.base_impl

import com.example.base.BaseFeatureApi
import com.example.base_impl.ui.empty.view.EmptyDialogFragment
import com.example.base_impl.ui.error.view.ErrorDialogFragment
import com.example.params.EmptyDialogParams
import com.example.params.ErrorDialogParams
import javax.inject.Inject

class BaseFeatureApiImpl @Inject constructor() : BaseFeatureApi {

    override fun getErrorDialog(params: ErrorDialogParams?) = ErrorDialogFragment.create(params)

    override fun getEmptyDialog(params: EmptyDialogParams?) = EmptyDialogFragment.create(params)
}
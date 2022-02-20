package com.example.base_impl

import com.example.base.BaseFeatureApi
import com.example.base_impl.ui.empty.view.EmptyDialogFragment
import com.example.base_impl.ui.error.view.ErrorDialogFragment
import javax.inject.Inject

class BaseFeatureApiImpl @Inject constructor() : BaseFeatureApi {

    override fun getErrorDialog() = ErrorDialogFragment.create()

    override fun getEmptyDialog() = EmptyDialogFragment.create()
}
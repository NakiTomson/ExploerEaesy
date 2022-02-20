package com.testtask.dashboard_impl.ui.dashboard_page.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.testtask.base.BaseFragment
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard_page.model.DashBoardPageViewModel
import com.testtask.entity.DashBoardScreenEntity
import kotlinx.android.synthetic.main.fragment_bashboard_page.*

class DashBoardPageFragment : BaseFragment<DashBoardPageViewModel>(R.layout.fragment_bashboard_page) {

    override val viewModel: DashBoardPageViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<DashBoardScreenEntity>(ARG_PAGE_CONTENT)?.let {
            setContent(it)
        }
    }

    private fun setContent(dashBoardScreenEntity: DashBoardScreenEntity) {
        dashBoardScreenEntity.apply {
            setProgressBarVisibility(true)
            tvTitle.text = title
            tvContent.text = text
            Glide.with(this@DashBoardPageFragment)
                .load(media)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        setProgressBarVisibility(false)
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        setProgressBarVisibility(false)
                        return false
                    }

                })
                .into(ivPicture)
        }
    }

    private fun setProgressBarVisibility(isVisible: Boolean) {
        progressDashBoardPage.isVisible = isVisible
    }

    companion object {

        const val ARG_PAGE_CONTENT = "ARG_PAGE_CONTENT"

        fun create(onBoardingPage: DashBoardScreenEntity) = DashBoardPageFragment().apply {
            arguments = bundleOf(ARG_PAGE_CONTENT to onBoardingPage)
        }
    }
}
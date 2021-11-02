package com.testtask.dashboard_impl.ui.dashboard_page.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.testtask.dashboard_impl.R
import com.testtask.entity.BoardScreenEntity
import kotlinx.android.synthetic.main.fragment_bashboard_page.*

class BashBoardPageFragment : Fragment(R.layout.fragment_bashboard_page) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onBoardingPage =
            arguments?.getParcelable<BoardScreenEntity>(ARG_PAGE_CONTENT) ?: error("OnBoarding page should has an argument")
        onBoardingPage.apply {
            tvTitle.text = title
            tvContent.text = text
            media.let {
                Glide.with(ivPicture)
                    .load(it)
                    .into(ivPicture)
            }
        }
    }

    companion object {

        const val ARG_PAGE_CONTENT = "ARG_CONTENT"

        fun create(
            onBoardingPage: BoardScreenEntity
        ) = BashBoardPageFragment().apply {
            arguments = bundleOf(ARG_PAGE_CONTENT to onBoardingPage)
        }
    }
}
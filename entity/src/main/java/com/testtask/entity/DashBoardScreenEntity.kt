package com.testtask.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DashBoardScreenEntity(
    val title: String,
    val text: String,
    val media: String
) : Parcelable
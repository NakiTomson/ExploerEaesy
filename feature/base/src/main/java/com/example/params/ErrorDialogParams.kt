package com.example.params

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ErrorDialogParams(val imageUrl: String, val title: String, val description: String) : Parcelable
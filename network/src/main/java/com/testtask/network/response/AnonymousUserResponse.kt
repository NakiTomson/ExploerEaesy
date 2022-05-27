package com.testtask.network.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnonymousUserResponse(
    val anonymousToken: String?
) : Parcelable
package com.testtask.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnonymousUserResponse(
    @SerializedName("anonymous_token")
    val anonymousToken: String?
) : Parcelable
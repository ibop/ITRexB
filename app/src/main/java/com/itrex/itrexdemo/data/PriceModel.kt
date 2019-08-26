package com.itrex.itrexdemo.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PriceModel (
    var key: String = "",
    var value: Float = 0f,
    var up: Boolean = true
) : Parcelable
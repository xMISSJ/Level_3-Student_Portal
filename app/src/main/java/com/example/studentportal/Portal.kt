package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal(
    val portalName: String,
    val portalUrl: String
) : Parcelable

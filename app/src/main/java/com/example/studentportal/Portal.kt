package com.example.studentportal

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal(
    val portalName: String,
    val portalUri: Uri?
) : Parcelable

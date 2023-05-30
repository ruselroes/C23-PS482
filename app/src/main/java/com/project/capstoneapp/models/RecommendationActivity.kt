package com.project.capstoneapp.models

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class RecommendationActivity(
    var name: String = "",
    var time: Int = 0,
    var image: @RawValue Drawable? = null,
) : Parcelable

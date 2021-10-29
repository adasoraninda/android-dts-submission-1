package com.adasoraninda.githubuserdts

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @DrawableRes val avatar: Int,
    val username: String
) : Parcelable
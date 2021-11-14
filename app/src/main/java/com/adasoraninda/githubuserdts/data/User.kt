package com.adasoraninda.githubuserdts.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @DrawableRes val avatar: Int,
    val username: String,
    val name: String
) : Parcelable
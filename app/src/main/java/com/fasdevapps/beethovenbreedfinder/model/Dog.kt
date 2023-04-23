package com.fasdevapps.beethovenbreedfinder.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog (
    val id: Long,
    val index: Int,
    val name: String,
    val type: String,
    val heightFemale: Double,
    val heightMale: Double,
    val imageUrl: String,
    val lifeExpectancy: String,
    val temperament: String,
    val weightFemale: String,
    val weightMale: String,
) : Parcelable
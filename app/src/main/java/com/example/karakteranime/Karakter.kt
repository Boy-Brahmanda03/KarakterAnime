package com.example.karakteranime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Karakter(
    val name: String,
    val description: String,
    val photo: String,
    val birthday: String,
    val height: Int
): Parcelable

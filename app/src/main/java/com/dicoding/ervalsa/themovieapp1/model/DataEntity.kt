package com.dicoding.ervalsa.themovieapp1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntity(
    var id: String,
    var title: String,
    var description: String,
    var genre: String,
    var realeaseYear: String,
    var imgPoster: Int,
    var imgBackground: Int
) : Parcelable
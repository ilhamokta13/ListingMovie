package com.example.listingmovie.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class DetailMovie(

    val image: String,
    val title: String,
    val media_type: String,
    val date: String,
    val overview: String,
) : Parcelable

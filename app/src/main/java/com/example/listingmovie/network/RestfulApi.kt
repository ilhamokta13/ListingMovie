package com.example.listingmovie.network

import com.example.listingmovie.model.ListMovie
import com.example.listingmovie.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestfulApi {

    @GET("3/movie/634649/recommendations?api_key=7f40338572c7bcecdd056ae5622e950d&language=en-US&page=1")
    fun allMoviesRecom(): Call<ListMovie>

}
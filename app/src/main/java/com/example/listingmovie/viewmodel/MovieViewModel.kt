package com.example.listingmovie.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listingmovie.adapter.MovieAdapter
import com.example.listingmovie.model.ListMovie
import com.example.listingmovie.model.Result
import com.example.listingmovie.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections.list
import kotlin.coroutines.coroutineContext


class MovieViewModel : ViewModel() {

    private val moviesrecom : MutableLiveData<List<Result>> by lazy {
        MutableLiveData<List<Result>>().also {
           getAllMoviesrecom()
        }
    }

    fun getMovies(): LiveData<List<Result>> {
        return moviesrecom
    }

    private fun getAllMoviesrecom(){
        RetrofitClient.instance.allMoviesRecom().enqueue(object : Callback<ListMovie>{
            override fun onResponse(call: Call<ListMovie>, response: Response<ListMovie>) {

                moviesrecom.value = response.body()?.results

            }

            override fun onFailure(call: Call<ListMovie>, t: Throwable) {
                Log.d("Tag",t.message.toString())

            }

        })
    }



}



















package com.example.listingmovie.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listingmovie.R
import com.example.listingmovie.adapter.MovieAdapter
import com.example.listingmovie.databinding.FragmentHomeBinding
import com.example.listingmovie.model.Result
import com.example.listingmovie.network.RetrofitClient
import com.example.listingmovie.viewmodel.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var pref: SharedPreferences

    private val ViewModel: MovieViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataMovie()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pref = requireActivity().getSharedPreferences("Regist", Context.MODE_PRIVATE)
        val fullname = pref.getString("username", "username")
        binding.welcome.text = "Welcome, $fullname!"


        //Profile
        binding.btnProfile.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_profileFragment)
        }


    }



    private fun getDataMovie() {
        Log.d("Tag", "Fragment activity : datanya ->")
        ViewModel.getMovies().observe(requireActivity()) {
            Log.d("Tag", "Fragment activity : datanya -> $it")
            val adapter = MovieAdapter(it)
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.rvFilm.layoutManager = layoutManager
            binding.rvFilm.adapter = adapter
        }


    }











//    fun showDataFilm(){
//        val viewModelNews = ViewModelProvider(this).get(MovieViewModel::class.java)
//        viewModelNews.callApiMovie()
//        viewModelNews.liveDataMovie.observe(this, Observer {
//            if (it != null){
//                binding.rvFilm.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
//                binding.rvFilm.adapter = MovieAdapter(listMovie)
//            }
//        })
//    }




//    override fun onResume() {
//        super.onResume()
//        val userId = pref.getString("id", "0")
//        viewModel.callApiMovie()
//        //Retrofit
//        showCallApiMovie()
//    }



}





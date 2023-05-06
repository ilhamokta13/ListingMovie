package com.example.listingmovie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.listingmovie.R
import com.example.listingmovie.databinding.FragmentDetailBinding
import com.example.listingmovie.model.DetailMovie
import com.example.listingmovie.model.Result
import com.example.listingmovie.viewmodel.MovieViewModel



class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // pengambilan data
       val getData = arguments?.getParcelable<DetailMovie>("data_movie") as DetailMovie
            val nama = getData.title
            val media = getData.media_type
            val date = getData.date
            val sinopsis = getData.overview
            val image = getData.image

            binding.tvNamafilmdetail.text = nama
            binding.tvMediaTypeDate.text = media
            binding.tvDate.text = date
            binding.tvSinopsisfilmdetail.text = sinopsis

            Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${image}")
                .into(binding.ivFilmimagedetail)

        }

    }













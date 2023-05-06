package com.example.listingmovie.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.listingmovie.MainActivity
import com.example.listingmovie.R

import com.example.listingmovie.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.util.*

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var pref: SharedPreferences
    lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = requireActivity().getSharedPreferences("Regist", Context.MODE_PRIVATE)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.btnReg.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnIndo.setOnClickListener {
            setindo("id")
        }

        binding.btnEng.setOnClickListener {
            seteng("eng")
        }

    }

    fun login(){
        val email = binding.emailEditText.text.toString()
        val password = binding.passEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context,"Login Berhasil", Toast.LENGTH_LONG).show()
                    Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_homeFragment)
                }else{
                    Toast.makeText(context, "Coba Cek Email dan password kembali",Toast.LENGTH_LONG).show()
                }
            }
        }

    }



    private fun setindo(indo: String) {
        var locale : Locale = Locale("id")
        Locale.setDefault(locale)

        var config: Configuration = Configuration()
        config.locale = locale

        val res = resources
        res.updateConfiguration(config, res.displayMetrics)
        val intent = Intent(activity, MainActivity::class.java)
        requireActivity().startActivity(intent)

    }

    private fun seteng(eng: String) {
        var locale : Locale = Locale("en")
        Locale.setDefault(locale)

        var config: Configuration = Configuration()
        config.locale = locale

        val res = resources
        res.updateConfiguration(config, res.displayMetrics)
        val intent = Intent(activity, MainActivity::class.java)
        requireActivity().startActivity(intent)

    }



}

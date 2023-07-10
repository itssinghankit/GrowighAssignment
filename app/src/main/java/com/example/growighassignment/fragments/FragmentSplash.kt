package com.example.growighassignment.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.growighassignment.R
import com.example.growighassignment.databinding.FragmentOnboardingBinding
import com.example.growighassignment.databinding.FragmentSplashBinding

class FragmentSplash : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentSplashBinding.inflate(layoutInflater)

        Handler().postDelayed({
            if(getOnBoardingStatus()){
                findNavController().navigate(R.id.action_fragmentSplash_to_fragmentHome)
            }else{
                //first time
                findNavController().navigate(R.id.action_fragmentSplash_to_fragmentOnboarding)
            }

        },1000)

        return binding.root
    }

    private fun getOnBoardingStatus():Boolean{
        val sharedPreferences=requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("Finished",false)
    }

}
package com.example.growighassignment.fragments.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.growighassignment.R
import com.example.growighassignment.databinding.FragmentMissonBinding
import com.example.growighassignment.databinding.FragmentVisionBinding

class FragmentVision : Fragment() {

    private lateinit var binding: FragmentVisionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentVisionBinding.inflate(layoutInflater)

        binding.skipBtn.setOnClickListener{
            onBoardingFinished()
            findNavController().navigate(R.id.action_fragmentOnboarding_to_fragmentHome)
        }

        binding.next.setOnClickListener {
            onBoardingFinished()
            findNavController().navigate(R.id.action_fragmentOnboarding_to_fragmentHome)
        }

        return binding.root
    }

    private fun onBoardingFinished() {
        val sharedPreferences=requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit().putBoolean("Finished",true).apply()
    }

}
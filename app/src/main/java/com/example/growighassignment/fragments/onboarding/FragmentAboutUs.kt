package com.example.growighassignment.fragments.onboarding

import android.content.Context
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.growighassignment.R
import com.example.growighassignment.databinding.FragmentAboutUsBinding


class FragmentAboutUs : Fragment() {

    private lateinit var binding:FragmentAboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAboutUsBinding.inflate(layoutInflater)

        val viewpager=activity?.findViewById<ViewPager2>(R.id.viewPager2)

        binding.next.setOnClickListener {
            viewpager?.currentItem=1
        }

        binding.skipBtn.setOnClickListener{
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
package com.example.growighassignment.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.fragment.app.FragmentManager
import com.example.growighassignment.R
import com.example.growighassignment.adapter.OnboardVPAdapter
import com.example.growighassignment.databinding.FragmentOnboardingBinding

class FragmentOnboarding : Fragment() {

private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(layoutInflater)

        val arraylist= arrayListOf(FragmentAboutUs(),FragmentMission(),FragmentVision())

        binding.viewPager2.adapter=OnboardVPAdapter(arraylist,requireActivity().supportFragmentManager,lifecycle)


        return binding.root
    }

}
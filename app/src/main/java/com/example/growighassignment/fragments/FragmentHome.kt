package com.example.growighassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.growighassignment.R
import com.example.growighassignment.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.feeds.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentFeeds)
        }

        binding.upldImg.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentUploadImg)
        }

        return binding.root
    }

}
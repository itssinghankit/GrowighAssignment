package com.example.growighassignment.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.growighassignment.R
import com.example.growighassignment.databinding.FragmentUploadImgBinding

class FragmentUploadImg : Fragment() {

    private lateinit var binding: FragmentUploadImgBinding
    private var uri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUploadImgBinding.inflate(layoutInflater)

        //for selecting image
        binding.slctImg.setOnClickListener {
            resultLauncher.launch("image/*")
        }
        binding.cross.setOnClickListener {
            resultLauncher.launch("image/*")
        }

        //for back btn
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentUploadImg_to_fragmentHome)
        }

        return binding.root
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        uri = it
        binding.img.setImageURI(it)
    }

}
package com.example.growighassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.service.RetrofitServiceBuilder
import com.example.growighassignment.adapter.ImgRecyclerAdapter
import com.example.growighassignment.databinding.FragmentFeedsBinding
import com.example.growighassignment.interfaces.RetrofitInterface
import com.example.growighassignment.modelClasses.ImgApiDC
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentFeeds : Fragment() {

    private lateinit var binding: FragmentFeedsBinding
    private lateinit var list: List<com.example.growighassignment.modelClasses.Result>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedsBinding.inflate(layoutInflater)

        binding.imageRecycler.layoutManager = LinearLayoutManager(context)

        //pagination concept
        var pageNo = 1
        imageFetch(pageNo.toString())

        //after swiping down
        binding.swipeRefresh.setOnRefreshListener {
            pageNo = pageNo + 1
            imageFetch(pageNo.toString())
            binding.swipeRefresh.isRefreshing = false
        }

        return binding.root
    }

    private fun imageFetch(pageNo: String) {
        val call = RetrofitServiceBuilder.buildService(RetrofitInterface::class.java)
        call.getImage(pageNo).enqueue(object : Callback<ImgApiDC?> {
            override fun onResponse(call: Call<ImgApiDC?>, response: Response<ImgApiDC?>) {

                if (response.isSuccessful) {
                    list = response.body()!!.results
                    binding.imageRecycler.adapter = ImgRecyclerAdapter(list, context!!)
                } else {
                    Toast.makeText(context, "Problem from Backend", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ImgApiDC?>, t: Throwable) {
                Toast.makeText(context, "Check your Connection", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
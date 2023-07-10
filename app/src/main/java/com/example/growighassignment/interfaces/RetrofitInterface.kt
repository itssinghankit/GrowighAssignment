package com.example.growighassignment.interfaces

import com.example.growighassignment.modelClasses.ImgApiDC
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("photos?&query=android&client_id=q9mt5PO7SFAW9tuYBYScqqQryyKimNnFW0sEsB-O2Ss")
    fun getImage(@Query("page")pageId: String):Call<ImgApiDC>

}
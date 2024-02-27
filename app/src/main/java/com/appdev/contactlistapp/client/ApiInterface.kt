package com.appdev.contactlistapp.client

import com.appdev.contactlistapp.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //api get request should be implemented
    @GET("/user_journey/contact_list/")
    fun getData(): Call<ResponseData>
}
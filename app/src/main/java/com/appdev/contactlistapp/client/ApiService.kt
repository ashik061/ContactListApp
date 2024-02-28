package com.appdev.contactlistapp.client

import com.appdev.contactlistapp.models.ResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //api get request should be implemented
    @GET("user_journey/contact_list/")
    suspend fun getData(): Response<ResponseData>

}
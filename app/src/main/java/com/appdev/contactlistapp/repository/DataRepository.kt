package com.appdev.contactlistapp.repository
// repository to manage the data and transfer to view model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appdev.contactlistapp.client.ApiService
import com.appdev.contactlistapp.models.ResponseData

class DataRepository(private val apiService: ApiService){  // access to retrofit api service

    // utilizing live data to render live changes in UI
    private val responseLiveData = MutableLiveData<Response<ResponseData>>()
    val response: LiveData<Response<ResponseData>>
        get() = responseLiveData

    suspend fun getData(){ // function to pass data to view model
        try {
            val result = apiService.getData()
            if(result?.body() != null){ // confirming response from api
                responseLiveData.postValue(Response.Success(result.body()))
            }

        }catch (e: Exception){
            responseLiveData.postValue(Response.Error(e.message.toString()))
        }

    }
}
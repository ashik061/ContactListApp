package com.appdev.contactlistapp.repository
// repository to manage the data and transfer to view model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appdev.contactlistapp.client.ApiService
import com.appdev.contactlistapp.models.ResponseData

class DataRepository(private val apiService: ApiService){  // access to retrofit api service

    // utilizing live data to render live changes in UI
    private val responseLiveData = MutableLiveData<ResponseData>()
    val response: LiveData<ResponseData>
        get() = responseLiveData

    suspend fun getData(){ // function to pass data to view model
        val result = apiService.getData()
        if(result?.body() != null){ // confirming response from api
            responseLiveData.postValue(result.body())
        }
    }
}
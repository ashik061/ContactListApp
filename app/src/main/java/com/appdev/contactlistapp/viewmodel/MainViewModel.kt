package com.appdev.contactlistapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appdev.contactlistapp.models.ResponseData
import com.appdev.contactlistapp.repository.DataRepository
import com.appdev.contactlistapp.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository) : ViewModel() { // view model accessing repository for data

    init {
        viewModelScope.launch(Dispatchers.IO) {// coroutine for suspend function
            repository.getData()
        }
    }

    // pointing live data of repository to update UI
    val response : LiveData<Response<ResponseData>>
        get() = repository.response

}
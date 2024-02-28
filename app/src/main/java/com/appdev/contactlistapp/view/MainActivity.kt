package com.appdev.contactlistapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.appdev.contactlistapp.R
import com.appdev.contactlistapp.client.ApiClient
import com.appdev.contactlistapp.client.ApiService
import com.appdev.contactlistapp.repository.DataRepository
import com.appdev.contactlistapp.viewmodel.MainViewModel
import com.appdev.contactlistapp.viewmodel.MainViewModelFactory
import retrofit2.create
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiClient.getInstance().create(ApiService::class.java)
        val repository = DataRepository(apiService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.response.observe(this, Observer {
            Log.d("APIDATA", it.result.toString())
        })

    }
}

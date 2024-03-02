package com.appdev.contactlistapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appdev.contactlistapp.R
import com.appdev.contactlistapp.adapter.RecyclerViewAdapter
import com.appdev.contactlistapp.client.ApiClient
import com.appdev.contactlistapp.client.ApiService
import com.appdev.contactlistapp.repository.DataRepository
import com.appdev.contactlistapp.viewmodel.MainViewModel
import com.appdev.contactlistapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.RecyclerViewEvent { // implemented interface to handle item click

    // Required instances
    private lateinit var mainViewModel : MainViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting up RecyclerView
        val contactListRecycler: RecyclerView = findViewById(R.id.contactListRecycler)
        contactListRecycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        contactListRecycler.layoutManager = linearLayoutManager

        // creating instance of the MainViewModel for required data
        val apiService = ApiClient.getInstance().create(ApiService::class.java)
        val repository = DataRepository(apiService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        // Updating the live data
        mainViewModel.response.observe(this, Observer {
            Log.d("APIDATA", it.result.toString())
            //findViewById<TextView>(R.id.txtId).text = it.result?.get(0)?.email.toString()

            recyclerViewAdapter = RecyclerViewAdapter(baseContext,this, it.result)
            recyclerViewAdapter.notifyDataSetChanged()
            contactListRecycler.adapter = recyclerViewAdapter
        })

    }

    // item click operation
    override fun onItemClick(position: Int) {
        val clickedItem = mainViewModel.response.value?.result?.get(position)
        Toast.makeText(this, clickedItem?.email, Toast.LENGTH_SHORT).show()

    }
}

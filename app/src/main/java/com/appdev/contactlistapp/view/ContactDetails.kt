package com.appdev.contactlistapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.appdev.contactlistapp.R
import com.squareup.picasso.Picasso

class ContactDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        // Retrieving data from the intent's extras
        val fullName = intent.getStringExtra("fullName")
        val email = intent.getStringExtra("email")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val image = intent.getStringExtra("image")

        // backButton
        val imageButton: ImageButton = findViewById(R.id.backButton)
        imageButton.setOnClickListener{
            Log.d("BUTTON", "ImageButton clicked")
            finish()
        }

        //Log.d("CHECK", image.toString())


        // Finding the layout instances
        val userName: TextView = findViewById(R.id.userName)
        val userEmail: TextView = findViewById(R.id.userEmail)
        val userPhoneNumber: TextView = findViewById(R.id.userPhoneNumber)
        val userImage: ImageView = findViewById(R.id.userImage)

        // Setting the values
        userName.text = fullName
        userEmail.text = email
        userPhoneNumber.text = phoneNumber
        Picasso.get().load(image).placeholder(R.drawable.baseline_account_circle_24).into(userImage)
    }
}
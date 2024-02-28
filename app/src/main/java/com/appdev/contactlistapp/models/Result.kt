package com.appdev.contactlistapp.models
// Result used in the ResponseData class

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("email")
    val email: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?
)

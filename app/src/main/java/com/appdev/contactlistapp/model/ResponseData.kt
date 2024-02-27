package com.appdev.contactlistapp.model
// Data class to receive response of the api

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("error")
    val error: Error?,
    @SerializedName("result")
    val result: List<Result?>?,
    @SerializedName("status")
    val status: Boolean?
) {
    data class Error(
        @SerializedName("code")
        val code: Any?,
        @SerializedName("message")
        val message: Any?
    )

    //there will be a list of user data in the result field of api response
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
}
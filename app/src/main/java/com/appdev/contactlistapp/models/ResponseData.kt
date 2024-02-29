package com.appdev.contactlistapp.models
// Data class to receive response of the api

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("error")
    val error: Error?,
    @SerializedName("result")
    val result: List<Result?>?,
    @SerializedName("status")
    val status: Boolean?
)


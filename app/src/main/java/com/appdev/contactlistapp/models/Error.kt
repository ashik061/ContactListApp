package com.appdev.contactlistapp.models
// Error used in the ResponseData class

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("code")
    val code: Any?,
    @SerializedName("message")
    val message: Any?
)

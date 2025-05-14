package com.aditya.gif_app.ApiServices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCallSesrvices {



    fun getApiCall(): ApiInterface {

       val retrofit=Retrofit.Builder()
            .baseUrl("https://api.giphy.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
             .create(ApiInterface::class.java)
             return  retrofit
    }

}
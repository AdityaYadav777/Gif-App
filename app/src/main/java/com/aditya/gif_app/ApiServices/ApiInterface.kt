package com.aditya.gif_app.ApiServices

import com.aditya.gif_app.Models.GifTrendyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("/v1/gifs/trending/")
    suspend  fun getGifTrndy(@Query("api_key") api_key:String="hILOux6xdJivUtUFM1ATDQWiJvt9xrTr"):Response<GifTrendyModel>

    @GET("/v1/gifs/search")
    suspend fun searchGif(@Query("api_key") api_key:String="hILOux6xdJivUtUFM1ATDQWiJvt9xrTr",
                          @Query("q") q:String,
                          ):Response<GifTrendyModel>

}
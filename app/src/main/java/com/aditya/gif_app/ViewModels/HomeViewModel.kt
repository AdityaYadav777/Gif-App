package com.aditya.gif_app.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.gif_app.ApiServices.ApiCallSesrvices
import com.aditya.gif_app.Models.GifTrendyModel
import com.aditya.gif_app.Models.Original
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {

    private val getData= MutableStateFlow<List<Original>>(emptyList())
    val _getData=getData.asStateFlow()




    init {

        getData()
    }


    fun SearchData(data:String){
        getData.value= emptyList()
        val listOfdata= arrayListOf<Original>()
        viewModelScope.launch {
            val response=ApiCallSesrvices.getApiCall().searchGif(q = data)
            if(response.isSuccessful){
                Log.i("MERAAPIDATA",response.body().toString())
                val data=response.body()!!

                for(i in data.data){
                    val data=i.images.original
                    listOfdata.add(data)
                    getData.value=listOfdata
                }

            }else{
                Log.i("MERAAPIDATA","Some Error Occured")
            }

        }

    }


    fun getData(){
        val listOfdata= arrayListOf<Original>()
        viewModelScope.launch {
            val response= ApiCallSesrvices.getApiCall().getGifTrndy()
            if(response.isSuccessful){
                Log.i("MERAAPIDATA",response.body().toString())
                val data=response.body()!!

                for(i in data.data){
                   val data=i.images.original
                    listOfdata.add(data)
                    getData.value=listOfdata
                }

            }else{
                Log.i("MERAAPIDATA","Some Error Occured")
            }

        }

    }

}
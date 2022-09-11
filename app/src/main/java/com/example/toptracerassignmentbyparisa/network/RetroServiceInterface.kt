package com.example.toptracerassignmentbyparisa.network

import com.example.toptracerassignmentbyparisa.DataResult
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("gifs/trending?api_key=9yn1hfOgjya6fUVXGuyz9OCAaA6pO3bF")
    fun getGifs() : retrofit2.Call<DataResult>?
}
package com.example.toptracerassignmentbyparisa.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {

    companion object {
        val baseURL =
            "https://api.giphy.com/v1/"//gifs/trending?api_key=9yn1hfOgjya6fUVXGuyz9OCAaA6pO3bF

        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}
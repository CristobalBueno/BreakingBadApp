package com.example.cristobalbuenoexam.Api

import com.example.cristobalbuenoexam.Models.Result
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("characters")
    fun getEvents() : Call<Result>
}
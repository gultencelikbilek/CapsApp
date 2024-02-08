package com.example.castapp.api

import com.example.castapp.model.Caps
import com.example.castapp.model.CapsItem
import com.example.castapp.model.CapsResponse
import com.example.castapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllCaps() : Response<CapsResponse>
}
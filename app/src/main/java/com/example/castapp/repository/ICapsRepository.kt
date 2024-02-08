package com.example.castapp.repository

import com.example.castapp.model.Caps
import com.example.castapp.model.CapsItem
import com.example.castapp.model.CapsResponse
import retrofit2.Response

interface ICapsRepository {

    suspend fun getAllCaps() : List<CapsItem>?
}
package com.example.castapp.di

import android.util.Log
import com.example.castapp.api.ApiService
import com.example.castapp.model.CapsItem
import com.example.castapp.repository.ICapsRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CapsRepositoryImpl @Inject constructor(private val apiService: ApiService): ICapsRepository {
    override suspend fun getAllCaps(): List<CapsItem>? {
        val response = apiService.getAllCaps()
        if (response.isSuccessful) {
            return response.body()?.data?.memes
        }
        return null
    }
}
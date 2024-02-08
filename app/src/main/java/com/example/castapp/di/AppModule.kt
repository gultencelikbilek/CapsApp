package com.example.castapp.di

import com.example.castapp.api.ApiService
import com.example.castapp.repository.ICapsRepository
import com.example.castapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesRetrofit() : ApiService =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRepository(
        apiService: ApiService
    ): ICapsRepository = CapsRepositoryImpl(apiService)

}
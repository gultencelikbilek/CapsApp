package com.example.castapp.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.castapp.di.CapsRepositoryImpl
import com.example.castapp.model.CapsItem
import com.example.castapp.repository.ICapsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val capsRepository: ICapsRepository) :
    ViewModel() {

    private val _caps = MutableLiveData<List<CapsItem>?>()
    val caps: LiveData<List<CapsItem>?>
        get() = _caps

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getAllCaps() {
        viewModelScope.launch {
            val result = capsRepository.getAllCaps()
            _caps.postValue(result)
        }
    }
}



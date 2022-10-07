package com.nearmusic.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.nearmusic.data.GeneroDatabase
import com.nearmusic.model.Genero
import com.nearmusic.repository.GeneroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeneroViewModel(application: Application) : AndroidViewModel(application) {

    private val generoRepository: GeneroRepository
    val getGeneros: LiveData<List<Genero>>

    init {
        val generoDao = GeneroDatabase.getDatabase(application).generoDao()
        generoRepository = GeneroRepository(generoDao)
        getGeneros = generoRepository.getGeneros

    }

    fun saveGenero(genero: Genero) {

        viewModelScope.launch(Dispatchers.IO) {
            generoRepository.saveGenero(genero)
        }
    }

    fun deleteLGenero(genero: Genero) {

        viewModelScope.launch(Dispatchers.IO) {
           generoRepository.deleteGenero(genero)
        }
    }

}
package com.nearmusic.repository

import androidx.lifecycle.LiveData
import com.nearmusic.data.GeneroDao
import com.nearmusic.model.Genero

class GeneroRepository(private val generoDao: GeneroDao) {

    suspend fun saveGenero(genero: Genero) {
        if (genero.id == 0) {
            generoDao.addGenero(genero)
        } else {
            generoDao.updateGenero(genero)
        }
    }

    suspend fun deleteGenero(genero: Genero) {
        if (genero.id == 0) {
            generoDao.deleteGenero(genero)
        }
    }

    val getGeneros : LiveData<List<Genero>> = generoDao.getGeneros()

}
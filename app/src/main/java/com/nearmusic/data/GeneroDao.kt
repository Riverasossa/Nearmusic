package com.nearmusic.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nearmusic.model.Genero

@Dao

interface GeneroDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGenero(genero: Genero)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateGenero(genero: Genero)

    @Delete
    suspend fun deleteGenero(genero: Genero)

    @Query("SELECT * FROM GENERO")
    fun getGeneros() : LiveData<List<Genero>>


}
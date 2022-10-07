package com.nearmusic.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "genero")
data class Genero(
@PrimaryKey(autoGenerate = true)
val id: Int,
@ColumnInfo(name = "nombre")
val nombre: String,
@ColumnInfo(name = "ruta_imagen")
val rutaImagen: String?
) : Parcelable

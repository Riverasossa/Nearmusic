package com.nearmusic.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nearmusic.model.Genero

@Database(entities = [Genero::class], version = 1, exportSchema = false)

abstract class GeneroDatabase : RoomDatabase() {

    abstract fun generoDao(): GeneroDao

    companion object {
        @Volatile
        private var INSTANCE: GeneroDatabase? = null
        fun getDatabase(context: Context): GeneroDatabase {
            val local = INSTANCE
            if (local != null) {
                return local
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GeneroDatabase::class.java,
                    "Genero_Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


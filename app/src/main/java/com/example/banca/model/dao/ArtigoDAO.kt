package com.example.banca.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.banca.model.entity.Artigo

@Dao
interface ArtigoDAO{

    @Query("Select * from artigo_table")
    fun getAllArtigo() : LiveData<List<Artigo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(artigo: Artigo)

    @Query("Delete from artigo_table")
    suspend fun deleteAll()

}
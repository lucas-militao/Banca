package com.example.banca.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.banca.model.entity.Edicao

@Dao
interface EdicaoDAO {

    @Query("Select * from edicao_table")
    fun getAllEdicao() : LiveData<List<Edicao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(edicao: Edicao)

    @Query("Delete from edicao_table")
    suspend fun deleteAll()

}
package com.example.banca.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.banca.model.entity.Revista
import com.example.banca.model.joinclasses.RevistaEdicao

@Dao
interface RevistaDAO {

    @Query("Select * From revista_table")
    fun getAllRevista() : LiveData<List<Revista>>

    @Query("Select * From revista_table")
    fun getAllRevistasEdicoes() : LiveData<List<RevistaEdicao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(revista: Revista)

    @Query("Delete From revista_table")
    suspend fun deleteAll()

}
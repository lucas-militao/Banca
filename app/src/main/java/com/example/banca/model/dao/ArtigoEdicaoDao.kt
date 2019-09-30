package com.example.banca.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.joinclasses.EdicaoArtigos

@Dao
interface ArtigoEdicaoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArtigoEdicao(artigoEdicao: ArtigoEdicao)

    @Query("Select * From artigo_edicao_table Where artigoID = :id")
    fun queryEdicaoArtigosById(id: Int): LiveData<EdicaoArtigos>

}
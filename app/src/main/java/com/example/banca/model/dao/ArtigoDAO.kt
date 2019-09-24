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

//    @Query(
//        "Select ed.edicaoID as edicaoID, ed.edicaoNome as edicaoNome, art.artigoID as artigoID, art.artigoNome as artigoNome from edicao_table as ed, (Select art.artigoID as artigoID, ed.edicaoID as edicaoID, art.artigoNome as artigoNome From artigo_table as art, artigo_edicao_table as ed where art.artigoID = ed.artigoID) as art where ed.edicaoID = art.edicaoID"
//    )
//    fun getArtigoEdicao() : LiveData<List<Any>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(artigo: Artigo)

    @Query("Delete from artigo_table")
    fun deleteAll()

}
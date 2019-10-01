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

    @Query("""Select distinct * from artigo_table
        INNER JOIN (Select artigo_edicao_table.artigoID 
        From edicao_table INNER JOIN artigo_edicao_table ON edicao_table.edicaoID = artigo_edicao_table.edicaoID
        WHERE edicao_table.edicaoID = :id)
        AS a ON artigo_table.artigoID = a.artigoID
    """)
    fun queryArtigosFromEdicaoByID(id: Int) : LiveData<List<Artigo>>

    @Query("""Select * from artigo_table
        INNER JOIN artigo_edicao_table ON artigo_table.artigoID = artigo_edicao_table.artigoID
        INNER JOIN edicao_table ON edicao_table.edicaoID = artigo_edicao_table.edicaoID
        INNER JOIN revista_table ON revista_table.revistaID = edicao_table.revistaID
        Where revista_table.revistaID = :id
    """)
    fun queryArtigosFromRevistaById(id: Int) : LiveData<List<Artigo>>

    @Query("Delete from artigo_table")
    suspend fun deleteAll()

}
package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "artigo_edicao_table")
data class ArtigoEdicao(
        @PrimaryKey
        @ForeignKey(
                entity = Artigo::class,
                parentColumns = arrayOf("artigoID"),
                childColumns = arrayOf("artigoID"),
                onDelete = ForeignKey.CASCADE
        ) @ColumnInfo(name = "artigoID") val artigoID : Int,
        @ForeignKey(
                entity = Edicao::class,
                parentColumns = arrayOf("edicaoID"),
                childColumns = arrayOf("edicaoID"),
                onDelete = ForeignKey.CASCADE
        ) @ColumnInfo(name = "edicaoID") val edicaoID : Int
)
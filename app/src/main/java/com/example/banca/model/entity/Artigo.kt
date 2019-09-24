package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artigo_table")
data class Artigo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "artigoID") val artigoID: Int,
    @ColumnInfo(name = "artigoNome") val artigoNome: String
)
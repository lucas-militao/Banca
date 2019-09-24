package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "edicao_table")
data class Edicao(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "edicaoID") val edicaoID: Int
)
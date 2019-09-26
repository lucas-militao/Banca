package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "edicao_table")
data class Edicao(
    @ColumnInfo(name = "edicaoNome") val edicaoNome: String,
    @ForeignKey(entity = Revista::class,
            parentColumns = arrayOf("revistaID"),
            childColumns = arrayOf("revistaID"),
            onDelete = ForeignKey.CASCADE) @ColumnInfo(name = "revistaID") val revistaID: Int
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "edicaoID") var edicaoID: Int = 0

}
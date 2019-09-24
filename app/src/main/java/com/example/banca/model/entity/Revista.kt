package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "revista_table")
data class Revista(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "revistaID") val revistaID: Int,
    @ForeignKey(entity = Edicao::class,
                parentColumns = arrayOf("edicaoID"),
                childColumns = arrayOf("edicaoID"),
                onDelete = ForeignKey.CASCADE) @ColumnInfo(name = "edicaoID") val edicaoID: Int,
    @ColumnInfo(name = "revistaNome") val revistaNome: String
    )
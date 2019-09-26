package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "revista_table")
data class Revista(
    @ColumnInfo(name = "revistaNome") val revistaNome: String
)

{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "revistaID") var revistaID: Int = 0
}
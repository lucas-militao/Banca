package com.example.banca.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "artigo_edicao_table",
        primaryKeys = ["artigoID", "edicaoID"],
        foreignKeys = [
                ForeignKey(entity = Artigo::class,
                        parentColumns = ["artigoID"],
                        childColumns = ["artigoID"],
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(entity = Edicao::class,
                        parentColumns = ["edicaoID"],
                        childColumns = ["edicaoID"],
                        onDelete = ForeignKey.CASCADE)
        ])
class ArtigoEdicao {
        var artigoID: Int = 0
        var edicaoID: Int = 0
}



//        @PrimaryKey
//        @ForeignKey(
//                entity = Artigo::class,
//                parentColumns = arrayOf("artigoID"),
//                childColumns = arrayOf("artigoID"),
//                onDelete = ForeignKey.CASCADE
//        ) @ColumnInfo(name = "artigoID") val artigoID : Int,
//
//        @ForeignKey(
//                entity = Edicao::class,
//                parentColumns = arrayOf("edicaoID"),
//                childColumns = arrayOf("edicaoID"),
//                onDelete = ForeignKey.CASCADE
//        ) @ColumnInfo(name = "edicaoID") val edicaoID : Int
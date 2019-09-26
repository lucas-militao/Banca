package com.example.banca.model.joinclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.banca.model.entity.Edicao
import com.example.banca.model.entity.Revista

class RevistaEdicao {

    @Embedded
    var revista: Revista? = null
    @Relation(
            parentColumn = "revistaID",
            entityColumn = "revistaID"
    )
    var edicao: List<Edicao>? = null

}


//val revistaID: Int,
//val revistaNome: String,
//val edicaoID: Int,
//val edicaoNome: String
package com.example.banca.model.joinclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.entity.Edicao

class EdicaoArtigos {


        @Embedded
        lateinit var edicao: Edicao

        @Embedded
        var artigo: Artigo? = null
}
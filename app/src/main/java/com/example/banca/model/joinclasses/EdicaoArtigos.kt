package com.example.banca.model.joinclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.entity.Edicao

class EdicaoArtigos {
        @Embedded (prefix = "edicao_")
        var edicao: Edicao? = null

        @Embedded
        var artigo: Artigo? = null
}
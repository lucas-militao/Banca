package com.example.banca.repository

import androidx.lifecycle.LiveData
import com.example.banca.model.dao.ArtigoDAO
import com.example.banca.model.dao.EdicaoDAO
import com.example.banca.model.dao.RevistaDAO
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.Edicao
import com.example.banca.model.entity.Revista
import com.example.banca.model.joinclasses.RevistaEdicao

class BancaRepository (private val artigoDAO: ArtigoDAO,
                       private val edicaoDAO: EdicaoDAO,
                       private val revistaDAO: RevistaDAO) {

    val allArtigos: LiveData<List<Artigo>> = artigoDAO.getAllArtigo()
    val allRevistas: LiveData<List<Revista>> = revistaDAO.getAllRevista()

    suspend fun insertRevista(revista: Revista) {
        revistaDAO.insert(revista)
    }

    suspend fun insertArtigo(artigo: Artigo) {
        artigoDAO.insert(artigo)
    }

    suspend fun insertEdicao(edicao: Edicao) {
        edicaoDAO.insert(edicao)
    }

    fun queryRevistaEdicao(id: Int) : LiveData<RevistaEdicao>{
        return revistaDAO.getAllRevistaEdicoes(id)
    }

}
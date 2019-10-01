package com.example.banca.repository

import androidx.lifecycle.LiveData
import com.example.banca.model.dao.ArtigoDAO
import com.example.banca.model.dao.ArtigoEdicaoDao
import com.example.banca.model.dao.EdicaoDAO
import com.example.banca.model.dao.RevistaDAO
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.entity.Edicao
import com.example.banca.model.entity.Revista
import com.example.banca.model.joinclasses.EdicaoArtigos
import com.example.banca.model.joinclasses.RevistaEdicao

class BancaRepository (private val artigoDAO: ArtigoDAO,
                       private val edicaoDAO: EdicaoDAO,
                       private val revistaDAO: RevistaDAO,
                       private val artigoEdicaoDAO: ArtigoEdicaoDao) {

    val allArtigos: LiveData<List<Artigo>> = artigoDAO.getAllArtigo()
    val allRevistas: LiveData<List<Revista>> = revistaDAO.getAllRevista()
    val allEdicoes: LiveData<List<Edicao>> = edicaoDAO.getAllEdicao()
    val allArtigosEdicao: LiveData<List<ArtigoEdicao>> = artigoEdicaoDAO.allArtigoEdicao()

    suspend fun insertRevista(revista: Revista) {
        revistaDAO.insert(revista)
    }

    suspend fun insertArtigo(artigo: Artigo) {
        artigoDAO.insert(artigo)
    }

    suspend fun insertEdicao(edicao: Edicao) {
        edicaoDAO.insert(edicao)
    }

    fun queryRevistaEdicoes(id: Int) : LiveData<RevistaEdicao>{
        return revistaDAO.getAllRevistasEdicoesById(id)
    }

    fun queryEdicaoArtigos(id: Int) : LiveData<List<Artigo>> {
        return artigoDAO.queryArtigosFromEdicaoByID(id)
    }

    fun queryArtigosFromRevistaByID(id: Int) : LiveData<List<Artigo>> {
        return artigoDAO.queryArtigosFromRevistaById(id)
    }

}
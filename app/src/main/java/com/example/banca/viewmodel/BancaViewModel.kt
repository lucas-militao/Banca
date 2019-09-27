package com.example.banca.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.Edicao
import com.example.banca.model.entity.Revista
import com.example.banca.model.joinclasses.RevistaEdicao
import com.example.banca.repository.BancaRepository
import com.example.banca.roomdatabase.BancaRoomDatabase
import kotlinx.coroutines.launch

class BancaViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BancaRepository

    val allRevistas: LiveData<List<Revista>>
    val allArtigos: LiveData<List<Artigo>>
    val allEdicoes: LiveData<List<Edicao>>

    val allRevistasEdicoes: LiveData<List<RevistaEdicao>>

    init {

        val revistaDAO = BancaRoomDatabase.getDatabase(application, viewModelScope).revistaDao()
        val artigoDAO = BancaRoomDatabase.getDatabase(application, viewModelScope).artigoDao()
        val edicaoDAO = BancaRoomDatabase.getDatabase(application, viewModelScope).edicaoDao()

        repository = BancaRepository(artigoDAO, edicaoDAO, revistaDAO)

        allRevistas = repository.allRevistas
        allArtigos = repository.allArtigos
        allEdicoes = repository.allEdicoes

        allRevistasEdicoes = repository.allRevistasEdicoes
    }

    fun insertRevista(revista: Revista) = viewModelScope.launch {
        repository.insertRevista(revista)
    }

    fun insertEdicao(edicao: Edicao) = viewModelScope.launch {
        repository.insertEdicao(edicao)
    }

    fun insertArtigo(artigo: Artigo) = viewModelScope.launch {
        repository.insertArtigo(artigo)
    }

}
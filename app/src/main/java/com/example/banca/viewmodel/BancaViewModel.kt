package com.example.banca.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.entity.Edicao
import com.example.banca.model.entity.Revista
import com.example.banca.model.joinclasses.EdicaoArtigos
import com.example.banca.model.joinclasses.RevistaEdicao
import com.example.banca.repository.BancaRepository
import com.example.banca.roomdatabase.BancaRoomDatabase
import kotlinx.coroutines.launch

class BancaViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BancaRepository

    val allRevistas: LiveData<List<Revista>>
    val allArtigos: LiveData<List<Artigo>>
    val allEdicoes: LiveData<List<Edicao>>

    val allArtigosFromEdicao: LiveData<List<ArtigoEdicao>>

    var allRevistaEdicoes: MediatorLiveData<RevistaEdicao> = MediatorLiveData()
    private var _allRevistaEdicoes: LiveData<RevistaEdicao> = MutableLiveData()

    var allEdicaoArtigos: MediatorLiveData<List<Artigo>> = MediatorLiveData()
    private var _allEdicaoArtigos: LiveData<List<Artigo>> = MutableLiveData()

    var allArtigosRevista: MediatorLiveData<List<Artigo>> = MediatorLiveData()
    private var _allArtigosRevista: LiveData<List<Artigo>> = MutableLiveData()


    init {

        val revistaDAO = BancaRoomDatabase.getDatabase(application, viewModelScope).revistaDao()
        val artigoDAO = BancaRoomDatabase.getDatabase(application, viewModelScope).artigoDao()
        val edicaoDAO = BancaRoomDatabase.getDatabase(application, viewModelScope).edicaoDao()
        val artigoEdicaoDao = BancaRoomDatabase.getDatabase(application, viewModelScope).artigoEdicaoDao()

        repository = BancaRepository(artigoDAO, edicaoDAO, revistaDAO, artigoEdicaoDao)

        allRevistas = repository.allRevistas
        allArtigos = repository.allArtigos
        allEdicoes = repository.allEdicoes

        allArtigosFromEdicao = repository.allArtigosEdicao

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

    fun queryRevistaEdicoes(id: Int) {
        allRevistaEdicoes.removeSource(_allRevistaEdicoes)
        _allRevistaEdicoes = repository.queryRevistaEdicoes(id)
        allRevistaEdicoes.addSource(_allRevistaEdicoes) {
            allRevistaEdicoes.value = it
        }
    }

    fun queryEdicaoArtigos(id: Int) {
        allEdicaoArtigos.removeSource(_allEdicaoArtigos)
        _allEdicaoArtigos = repository.queryEdicaoArtigos(id)
        allEdicaoArtigos.addSource(_allEdicaoArtigos) {
            allEdicaoArtigos.value = it
        }
    }

    fun queryArtigosRevista(id: Int) {
        allArtigosRevista.removeSource(_allArtigosRevista)
        _allArtigosRevista = repository.queryArtigosFromRevistaByID(id)
        allArtigosRevista.addSource(_allArtigosRevista) {
            allArtigosRevista.value = it
        }
    }
}
package com.example.banca.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.banca.R
import com.example.banca.adapter.EdicaoArtigosAdapter
import com.example.banca.viewmodel.BancaViewModel
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.toast

class EdicaoArtigosActivity : AppCompatActivity() {

    lateinit var bancaViewModel: BancaViewModel

    lateinit var edicaoArtigosAdapter: EdicaoArtigosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bancaViewModel = ViewModelProviders.of(this).get(BancaViewModel::class.java)

        setupView()
        subscribeUI()
    }

    private fun setupView() {

        edicaoArtigosAdapter = EdicaoArtigosAdapter(this)

        recyclerList.adapter = edicaoArtigosAdapter

        searchField.setHint("Artigos pelo id da Edição")

        searchButton.setOnClickListener {
            try {
                bancaViewModel.queryEdicaoArtigos(searchField.text.toString().toInt())
            } catch (e: Exception) {
                toast(e.message.toString())
            }
        }

    }

    private fun subscribeUI() {

        with(bancaViewModel) {

            allEdicaoArtigos.observe(this@EdicaoArtigosActivity, Observer {
                edicaoArtigosAdapter.setList(it)
            })

        }

    }

}
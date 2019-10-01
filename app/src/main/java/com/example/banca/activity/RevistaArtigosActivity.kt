package com.example.banca.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.banca.R
import com.example.banca.adapter.RevistaArtigosAdapter
import com.example.banca.viewmodel.BancaViewModel
import kotlinx.android.synthetic.main.activity_search.*
import java.lang.Exception

class RevistaArtigosActivity : AppCompatActivity() {

    lateinit var bancaViewModel: BancaViewModel
    lateinit var revistaArtigosAdapter: RevistaArtigosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bancaViewModel = ViewModelProviders.of(this).get(BancaViewModel::class.java)

        setupView()
        subscribeUI()
    }

    private fun setupView() {

        revistaArtigosAdapter = RevistaArtigosAdapter(this)

        recyclerList.adapter = revistaArtigosAdapter

        searchButton.setOnClickListener {
            try {
                bancaViewModel.queryArtigosRevista(searchField.text.toString().toInt())
            } catch (e: Exception) {
                print(e.message.toString())
            }
        }
    }

    private fun subscribeUI() {

        with(bancaViewModel) {

            allArtigosRevista.observe(this@RevistaArtigosActivity, Observer {
                revistaArtigosAdapter.setList(it)
            })

        }

    }
}
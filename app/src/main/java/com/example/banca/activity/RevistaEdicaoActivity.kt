package com.example.banca.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.banca.R
import com.example.banca.adapter.RevistaEdicaoAdapter
import com.example.banca.viewmodel.BancaViewModel
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_show_all.recyclerList
import org.jetbrains.anko.toast
import java.lang.Exception

class RevistaEdicaoActivity : AppCompatActivity() {

    lateinit var revistaEdicaoAdapter: RevistaEdicaoAdapter
    lateinit var bancaViewModel: BancaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bancaViewModel = ViewModelProviders.of(this).get(BancaViewModel::class.java)

        setupView()
        subscribeUI()
    }

    private fun setupView() {

        revistaEdicaoAdapter = RevistaEdicaoAdapter(this)

        recyclerList.adapter = revistaEdicaoAdapter

        searchButton.setOnClickListener {
            try {
                bancaViewModel.queryRevistaEdicoes(searchField.text.toString().toInt())
            } catch (e: Exception) {
                toast(e.message.toString())
            }
        }
    }

    private fun subscribeUI() {

        with(bancaViewModel) {
            allRevistaEdicoes.observe(this@RevistaEdicaoActivity, Observer {
                revistaEdicaoAdapter.setList(it)
            })
        }

    }

}
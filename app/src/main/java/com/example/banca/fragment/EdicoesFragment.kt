package com.example.banca.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.banca.R
import com.example.banca.adapter.EdicoesListAdapter
import com.example.banca.viewmodel.BancaViewModel
import kotlinx.android.synthetic.main.activity_search.*

class EdicoesFragment : Fragment() {

    lateinit var bancaViewModel: BancaViewModel
    lateinit var edicoesListAdapter: EdicoesListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_show_all, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bancaViewModel = ViewModelProviders.of(this).get(BancaViewModel::class.java)

        setupView()
        subscribeUI()
    }

    private fun setupView() {

        edicoesListAdapter = EdicoesListAdapter(activity!!)

        recyclerList.adapter = edicoesListAdapter

    }

    private fun subscribeUI() {

        with(bancaViewModel) {

            allEdicoes.observe(this@EdicoesFragment, Observer {
                edicoesListAdapter.setList(it)
            })

        }

    }

}
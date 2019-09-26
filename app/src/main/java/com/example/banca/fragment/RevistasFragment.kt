package com.example.banca.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.banca.R
import com.example.banca.activity.RevistaEdicaoActivity
import com.example.banca.adapter.RevistaListAdapter
import com.example.banca.viewmodel.BancaViewModel
import kotlinx.android.synthetic.main.fragment_show_all.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity

class RevistasFragment : Fragment() {

    lateinit var adapter: RevistaListAdapter
    lateinit var bancaViewModel: BancaViewModel

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
        adapter = RevistaListAdapter(activity!!)
        recyclerList.adapter = adapter

        searchButton.setOnClickListener {
            startActivity<RevistaEdicaoActivity>()
        }
    }

    private fun subscribeUI() {

        with(bancaViewModel) {

            this.allRevistas.observe(this@RevistasFragment, Observer {
                adapter.setRevistas(it)
            })

        }

    }

}
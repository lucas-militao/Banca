package com.example.banca.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.banca.R
import com.example.banca.adapter.RevistaListAdapter
import com.example.banca.viewmodel.BancaViewModel
import kotlinx.android.synthetic.main.fragment_revistas.*

class RevistasFragment : Fragment() {

    lateinit var adapter: RevistaListAdapter
    lateinit var bancaViewModel: BancaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_revistas, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bancaViewModel = ViewModelProviders.of(activity!!).get(BancaViewModel::class.java)

        setupView()
        subscribeUI()
    }

    private fun setupView() {
        adapter = RevistaListAdapter(activity!!)
        revistaList.adapter = adapter
    }

    private fun subscribeUI() {

        with(bancaViewModel) {

            this.allRevistas.observe(this@RevistasFragment, Observer {
                adapter.setRevistas(it)
            })

        }

    }

}
package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.entity.Artigo

class ArtigoListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<ArtigoListAdapter.ArtigoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var artigos = emptyList<Artigo>()

    inner class ArtigoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artigoEdicao: TextView = itemView.findViewById(R.id.campo1)
        val artigoNome: TextView = itemView.findViewById(R.id.campo2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtigoViewHolder {
        val layoutInflater = inflater.inflate(R.layout.view_holder, parent, false)
        return ArtigoViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = artigos.size

    override fun onBindViewHolder(holder: ArtigoViewHolder, position: Int) {
        var current = artigos[position]
        holder.artigoEdicao.text = current.artigoID.toString()
        holder.artigoNome.text = current.artigoNome
    }

    fun setArtigosList(artigos: List<Artigo>) {
        this.artigos = artigos
        notifyDataSetChanged()
    }
}
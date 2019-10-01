package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.entity.Artigo
import com.example.banca.model.entity.ArtigoEdicao
import com.example.banca.model.joinclasses.EdicaoArtigos

class EdicaoArtigosAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<EdicaoArtigosAdapter.EdicaoArtigosViewHolder>() {

    private var edicaoArtigosList: List<Artigo> = emptyList()

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)


    inner class EdicaoArtigosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coluna1 : TextView = itemView.findViewById(R.id.campo1)
        val coluna2 : TextView = itemView.findViewById(R.id.campo2)
        val coluna3 : TextView = itemView.findViewById(R.id.campo3)
        val coluna4 : TextView = itemView.findViewById(R.id.campo4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdicaoArtigosViewHolder {
        var inflater = layoutInflater.inflate(R.layout.view_holder, parent, false)
        return EdicaoArtigosViewHolder(inflater)
    }

    override fun getItemCount(): Int = edicaoArtigosList.size

    override fun onBindViewHolder(holder: EdicaoArtigosViewHolder, position: Int) {
        var current = edicaoArtigosList[position]

        holder.coluna1.text = current.artigoID.toString()
        holder.coluna2.text = current.artigoNome.toString()

    }

    fun setList(edicaoArtigosList: List<Artigo>) {
        this.edicaoArtigosList = edicaoArtigosList
        notifyDataSetChanged()
    }

}
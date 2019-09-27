package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.entity.Edicao

class EdicoesListAdapter internal constructor(
    context: Context
): RecyclerView.Adapter<EdicoesListAdapter.EdicoesListViewHolder>() {

    var edicoes = emptyList<Edicao>()
    val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class EdicoesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coluna1 : TextView = itemView.findViewById(R.id.campo1)
        val coluna2 : TextView = itemView.findViewById(R.id.campo2)
        val coluna3 : TextView = itemView.findViewById(R.id.campo3)
        val coluna4 : TextView = itemView.findViewById(R.id.campo4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdicoesListViewHolder {
        val itemView = inflater.inflate(R.layout.view_holder, parent, false)
        return EdicoesListViewHolder(itemView)
    }

    override fun getItemCount(): Int = edicoes.size

    override fun onBindViewHolder(holder: EdicoesListViewHolder, position: Int) {
        val current = edicoes[position]

        holder.coluna1.text = current.edicaoID.toString()
        holder.coluna2.text = current.edicaoNome
    }

    fun setList(edicoes: List<Edicao>) {
        this.edicoes = edicoes
        notifyDataSetChanged()
    }

}
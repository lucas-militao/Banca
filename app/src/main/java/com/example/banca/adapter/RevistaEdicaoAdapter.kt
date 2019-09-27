package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.joinclasses.RevistaEdicao

class RevistaEdicaoAdapter
internal constructor(context: Context) :
        RecyclerView.Adapter<RevistaEdicaoAdapter.RevistaEdicaoViewHolder>() {

    private var revistasEdicoes = emptyList<RevistaEdicao>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class RevistaEdicaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coluna1 : TextView = itemView.findViewById(R.id.campo1)
        val coluna2 : TextView = itemView.findViewById(R.id.campo2)
        val coluna3 : TextView = itemView.findViewById(R.id.campo3)
        val coluna4 : TextView = itemView.findViewById(R.id.campo4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaEdicaoViewHolder {
        val layoutInflater = inflater.inflate(R.layout.view_holder, parent, false)
        return RevistaEdicaoViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = revistasEdicoes.size

    override fun onBindViewHolder(holder: RevistaEdicaoViewHolder, position: Int) {

        val current = revistasEdicoes[position]

        holder.coluna1.text = current.revista?.revistaID.toString()
        holder.coluna2.text = current.revista?.revistaNome
        holder.coluna3.text = current.edicao?.get(0)?.edicaoID.toString()
        holder.coluna4.text = current.edicao?.get(0)?.edicaoNome

    }

    fun setList(revistasEdicoes: List<RevistaEdicao>) {
        this.revistasEdicoes = revistasEdicoes
        notifyDataSetChanged()
    }
}
package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.entity.Edicao
import com.example.banca.model.joinclasses.RevistaEdicao
import java.lang.Exception

class RevistaEdicaoAdapter
internal constructor(context: Context) :
        RecyclerView.Adapter<RevistaEdicaoAdapter.RevistaEdicaoViewHolder>() {

    private var revistaEdicoes = RevistaEdicao()
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

    override fun getItemCount(): Int {
        try {
            return revistaEdicoes.edicao?.size!!
        } catch (e: Exception) {
            return -1
        }
    }

    override fun onBindViewHolder(holder: RevistaEdicaoViewHolder, position: Int) {
        val current = revistaEdicoes.edicao

        holder.coluna1.text = revistaEdicoes.revista?.revistaID.toString()
        holder.coluna2.text = revistaEdicoes.revista?.revistaNome.toString()
        holder.coluna3.text = current?.get(position)?.edicaoID.toString()
        holder.coluna4.text = current?.get(position)?.edicaoNome
    }

    fun setList(revistasEdicoes: RevistaEdicao) {
        this.revistaEdicoes = revistasEdicoes
        notifyDataSetChanged()
    }
}
package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.entity.Artigo

class RevistaArtigosAdapter
internal constructor(context: Context) :
        RecyclerView.Adapter<RevistaArtigosAdapter.RevistaArtigosViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private var list : List<Artigo> = emptyList()

    inner class RevistaArtigosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coluna1 : TextView = itemView.findViewById(R.id.campo1)
        val coluna2 : TextView = itemView.findViewById(R.id.campo2)
        val coluna3 : TextView = itemView.findViewById(R.id.campo3)
        val coluna4 : TextView = itemView.findViewById(R.id.campo4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaArtigosViewHolder {
        val view = layoutInflater.inflate(R.layout.view_holder, parent, false)
        return RevistaArtigosViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RevistaArtigosViewHolder, position: Int) {
        var current = list[position]

        holder.coluna1.text = current.artigoID.toString()
        holder.coluna2.text = current.artigoNome.toString()
    }

    fun setList(list: List<Artigo>) {
        this.list = list
        notifyDataSetChanged()
    }


}
package com.example.banca.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banca.R
import com.example.banca.model.entity.Revista

class RevistaListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<RevistaListAdapter.RevistaViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var revistas = emptyList<Revista>()

    inner class RevistaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val revistaIdTxt: TextView = itemView.findViewById(R.id.txtRevistaId)
        val revistaNomeTxt: TextView = itemView.findViewById(R.id.txtRevistaNome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaViewHolder {
        val itemView = inflater.inflate(R.layout.revista_view_holder, parent, false)
        return RevistaViewHolder(itemView)
    }

    override fun getItemCount(): Int = revistas.size


    override fun onBindViewHolder(holder: RevistaViewHolder, position: Int) {
        val current = revistas[position]
        holder.revistaIdTxt.text = current.revistaID.toString()
        holder.revistaNomeTxt.text = current.revistaNome
    }

    internal fun setRevistas(revistas: List<Revista>) {
        this.revistas = revistas
        notifyDataSetChanged()
    }

}
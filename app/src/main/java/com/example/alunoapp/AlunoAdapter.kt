package com.exemplo.alunoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alunoapp.R

class AlunoAdapter(private val alunos: MutableList<Aluno>) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.nomeTextView)
        val areaTextView: TextView = itemView.findViewById(R.id.areaTextView)
        val dataTextView: TextView = itemView.findViewById(R.id.dataTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_aluno, parent, false)
        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.nomeTextView.text = aluno.nome
        holder.areaTextView.text = aluno.area
        holder.dataTextView.text = aluno.data
    }

    override fun getItemCount(): Int {
        return alunos.size
    }
}

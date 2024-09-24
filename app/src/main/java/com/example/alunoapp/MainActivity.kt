package com.exemplo.alunoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.alunoapp.R
import java.text.SimpleDateFormat
import java.util.*

data class Aluno(val nome: String, val area: String, val data: String)

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AlunoAdapter
    private val alunosList = mutableListOf<Aluno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = AlunoAdapter(alunosList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAlunos)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val nomeEditText = findViewById<EditText>(R.id.editTextNome)
        val areaEditText = findViewById<EditText>(R.id.editTextArea)
        val addButton = findViewById<Button>(R.id.buttonAdd)
        val zerarButton = findViewById<Button>(R.id.buttonZerar)
        val dataTextView = findViewById<TextView>(R.id.textViewData)
        val countTextView = findViewById<TextView>(R.id.textViewCount)

        addButton.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val area = areaEditText.text.toString()
            val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (nome.isNotEmpty() && area.isNotEmpty()) {
                alunosList.add(Aluno(nome, area, dataAtual))
                adapter.notifyDataSetChanged()
                countTextView.text = "Total de Alunos: ${alunosList.size}"
                dataTextView.text = "Data: $dataAtual"
            }
        }

        zerarButton.setOnClickListener {
            alunosList.clear()
            adapter.notifyDataSetChanged()
            countTextView.text = "Total de Alunos: 0"
            dataTextView.text = ""
        }
    }
}

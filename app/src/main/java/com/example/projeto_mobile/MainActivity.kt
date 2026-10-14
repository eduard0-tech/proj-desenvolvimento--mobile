package com.example.projeto_mobile

import Treino
import TreinoAdapter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// RF-10 - Meus treinos
class MainActivity : AppCompatActivity() {

    // Dados mock (só visual por enquanto)
    private val treinosMock = listOf(
        Treino("Treino A — Ficha Principal", "Peito e Tríceps", 6, treinoDoDia = true),
        Treino("Treino B — Ficha Principal", "Costas e Bíceps", 5),
        Treino("Treino C — Ficha Principal", "Pernas", 6),
        Treino("Treino D — Ficha Principal", "Ombros e Abdômen", 5)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvTreinos = findViewById<RecyclerView>(R.id.rvTreinos)
        rvTreinos.layoutManager = LinearLayoutManager(this)
        rvTreinos.adapter = TreinoAdapter(treinosMock) {
            // TODO: abrir detalhes do treino (navegação virá depois)
        }

        val tabAtual = findViewById<TextView>(R.id.tabAtual)
        val tabHistorico = findViewById<TextView>(R.id.tabHistorico)

        tabAtual.setOnClickListener { selecionarAba(tabAtual, tabHistorico) }
        tabHistorico.setOnClickListener { selecionarAba(tabHistorico, tabAtual) }
    }

    private fun selecionarAba(selecionada: TextView, outra: TextView) {
        selecionada.setBackgroundResource(R.drawable.bg_tab_selecionada)
        selecionada.setTextColor(getColor(R.color.treino_text_primary))
        outra.background = null
        outra.setTextColor(getColor(R.color.treino_text_secondary))
    }
}
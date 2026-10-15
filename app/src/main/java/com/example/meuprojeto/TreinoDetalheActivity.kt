package com.example.meuprojeto

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Detalhe do treino
class TreinoDetalheActivity : AppCompatActivity() {

    // Dados mock (só visual por enquanto)
    private val exerciciosMock = listOf(
        Exercicio("Supino reto", 4, 12),
        Exercicio("Supino inclinado", 4, 10),
        Exercicio("Crucifixo", 3, 12),
        Exercicio("Crossover", 3, 15),
        Exercicio("Tríceps corda", 4, 12),
        Exercicio("Tríceps francês", 3, 10)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_treino_detalhe)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.btnVoltar).setOnClickListener { finish() }

        val rvExercicios = findViewById<RecyclerView>(R.id.rvExercicios)
        rvExercicios.layoutManager = LinearLayoutManager(this)
        rvExercicios.adapter = ExercicioAdapter(exerciciosMock)

        findViewById<TextView>(R.id.btnIniciar).setOnClickListener {
            // TODO: iniciar treino (próxima tela)
        }
    }
}
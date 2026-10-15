package com.example.meuprojeto


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Execução do treino
class ExecucaoActivity : AppCompatActivity() {

    // Valores mock (só visual por enquanto)
    private var carga = 40
    private var repeticoes = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_execucao)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.btnVoltar).setOnClickListener { finish() }

        val tvCarga = findViewById<TextView>(R.id.tvCarga)
        val tvReps = findViewById<TextView>(R.id.tvReps)
        tvCarga.text = carga.toString()
        tvReps.text = repeticoes.toString()

        findViewById<TextView>(R.id.btnMenosCarga).setOnClickListener {
            carga = (carga - PASSO_CARGA).coerceAtLeast(0)
            tvCarga.text = carga.toString()
        }
        findViewById<TextView>(R.id.btnMaisCarga).setOnClickListener {
            carga += PASSO_CARGA
            tvCarga.text = carga.toString()
        }
        findViewById<TextView>(R.id.btnMenosReps).setOnClickListener {
            repeticoes = (repeticoes - PASSO_REPETICOES).coerceAtLeast(1)
            tvReps.text = repeticoes.toString()
        }
        findViewById<TextView>(R.id.btnMaisReps).setOnClickListener {
            repeticoes += PASSO_REPETICOES
            tvReps.text = repeticoes.toString()
        }

        findViewById<TextView>(R.id.btnPausar).setOnClickListener {
            // TODO: pausar / retomar o cronômetro de descanso
        }
        findViewById<TextView>(R.id.btnConcluir).setOnClickListener {
            // TODO: concluir a série e avançar
        }
    }

    private companion object {
        const val PASSO_CARGA = 5
        const val PASSO_REPETICOES = 1
    }
}
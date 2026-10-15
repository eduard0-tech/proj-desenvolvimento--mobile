package com.example.meuprojeto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExercicioAdapter(
    private val exercicios: List<Exercicio>
) : RecyclerView.Adapter<ExercicioAdapter.ExercicioViewHolder>() {

    class ExercicioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumero: TextView = view.findViewById(R.id.tvNumero)
        val tvNome: TextView = view.findViewById(R.id.tvNomeExercicio)
        val tvDetalhe: TextView = view.findViewById(R.id.tvSeriesRepeticoes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercicio, parent, false)
        return ExercicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExercicioViewHolder, position: Int) {
        val exercicio = exercicios[position]

        holder.tvNumero.text = (position + 1).toString()
        holder.tvNome.text = exercicio.nome
        holder.tvDetalhe.text = holder.itemView.context.getString(
            R.string.detalhe_series_repeticoes,
            exercicio.series,
            exercicio.repeticoes
        )
    }

    override fun getItemCount() = exercicios.size
}
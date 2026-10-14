import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_mobile.R

class TreinoAdapter(
    private val treinos: List<Treino>,
    private val onTreinoClick: (Treino) -> Unit = {}
) : RecyclerView.Adapter<TreinoAdapter.TreinoViewHolder>() {

    class TreinoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNome: TextView = view.findViewById(R.id.tvNomeTreino)
        val tvGrupo: TextView = view.findViewById(R.id.tvGrupoMuscular)
        val tvQtd: TextView = view.findViewById(R.id.tvQtdExercicios)
        val tvBadge: TextView = view.findViewById(R.id.tvBadgeDoDia)
        val btnIr: ImageView = view.findViewById(R.id.btnIr)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_treino, parent, false)
        return TreinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreinoViewHolder, position: Int) {
        val treino = treinos[position]

        holder.tvNome.text = treino.nome
        holder.tvGrupo.text = treino.gruposMusculares
        holder.tvQtd.text = holder.itemView.resources.getQuantityString(
            R.plurals.meus_treinos_qtd_exercicios,
            treino.qtdExercicios,
            treino.qtdExercicios
        )

        if (treino.treinoDoDia) {
            holder.itemView.setBackgroundResource(R.drawable.bg_card_treino_destaque)
            holder.tvBadge.visibility = View.VISIBLE
            holder.btnIr.setBackgroundResource(R.drawable.bg_circle_laranja)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.bg_card_treino)
            holder.tvBadge.visibility = View.GONE
            holder.btnIr.setBackgroundResource(R.drawable.bg_circle_cinza)
        }

        holder.itemView.setOnClickListener { onTreinoClick(treino) }
    }

    override fun getItemCount() = treinos.size
}
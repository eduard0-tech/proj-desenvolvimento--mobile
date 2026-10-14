import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_mobile.R

// RF-10 - Meus treinos
class MeusTreinosFragment : Fragment(R.layout.fragment_meus_treinos) {

    // Dados mock (só visual por enquanto)
    private val treinosMock = listOf(
        Treino("Treino A — Ficha Principal", "Peito e Tríceps", 6, treinoDoDia = true),
        Treino("Treino B — Ficha Principal", "Costas e Bíceps", 5),
        Treino("Treino C — Ficha Principal", "Pernas", 6),
        Treino("Treino D — Ficha Principal", "Ombros e Abdômen", 5)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvTreinos = view.findViewById<RecyclerView>(R.id.rvTreinos)
        rvTreinos.layoutManager = LinearLayoutManager(requireContext())
        rvTreinos.adapter = TreinoAdapter(treinosMock) {
            // TODO: abrir detalhes do treino (navegação virá depois)
        }

        val tabAtual = view.findViewById<TextView>(R.id.tabAtual)
        val tabHistorico = view.findViewById<TextView>(R.id.tabHistorico)

        tabAtual.setOnClickListener { selecionarAba(tabAtual, tabHistorico) }
        tabHistorico.setOnClickListener { selecionarAba(tabHistorico, tabAtual) }
    }

    private fun selecionarAba(selecionada: TextView, outra: TextView) {
        selecionada.setBackgroundResource(R.drawable.bg_tab_selecionada)
        selecionada.setTextColor(requireContext().getColor(R.color.treino_text_primary))
        outra.background = null
        outra.setTextColor(requireContext().getColor(R.color.treino_text_secondary))
    }
}
package pe.cibertec.edu.sistemamatricula.ui.alumnos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pe.cibertec.edu.sistemamatricula.databinding.FragmentAlumnosBinding

class AlumnosFragment : Fragment() {

    private var _binding: FragmentAlumnosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val InicioViewModel =
            ViewModelProvider(this).get(AlumnosViewModel::class.java)

        _binding = FragmentAlumnosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        InicioViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
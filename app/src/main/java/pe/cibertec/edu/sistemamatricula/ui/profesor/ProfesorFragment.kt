package pe.cibertec.edu.sistemamatricula.ui.profesor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import pe.cibertec.edu.sistemamatricula.databinding.FragmentProfesorBinding

class ProfesorFragment : Fragment() {

    private var _binding : FragmentProfesorBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfesorBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrueba.setOnClickListener {

            val fragment = ProfesorOperaFragment()
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            ft.replace(pe.cibertec.edu.sistemamatricula.R.id.action_nav_profesor_to_profesorOperaFragment, fragment, "fra")
            ft.addToBackStack(null)
            ft.commit()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
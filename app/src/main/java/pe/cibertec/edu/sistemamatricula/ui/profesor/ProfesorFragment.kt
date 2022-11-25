package pe.cibertec.edu.sistemamatricula.ui.profesor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pe.cibertec.edu.sistemamatricula.ProyectoApplication
import pe.cibertec.edu.sistemamatricula.R
import pe.cibertec.edu.sistemamatricula.adapter.ProfesorAdapter
import pe.cibertec.edu.sistemamatricula.databinding.FragmentProfesorBinding
import pe.cibertec.edu.sistemamatricula.viewmodel.ViewModelFactory

class ProfesorFragment : Fragment() {

    private var _binding: FragmentProfesorBinding? = null
    private lateinit var profesorAdapter : ProfesorAdapter

    val binding get() = _binding!!
    val profesorViewModel : ProfesorViewModel by viewModels {
        ViewModelFactory(repository2 = (requireActivity().application as ProyectoApplication).repoProfesor)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfesorBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profesorViewModel.listaProfesores.observe(viewLifecycleOwner) { listaProfesores ->
          binding.rvProfesor.adapter = ProfesorAdapter(listaProfesores, { prof ->

              val directions = ProfesorFragmentDirections.actionNavProfesorToProfesorOperaFragment(prof)
              findNavController().navigate(directions)
          }
          ) { prof ->
              MaterialAlertDialogBuilder(requireContext())
                  .setTitle(resources.getString(R.string.confirmacion))
                  .setMessage(resources.getString(R.string.mensajeeliminar, prof.nombre))
                  .setPositiveButton(resources.getString(R.string.aceptar)) { _, _ ->

                      profesorViewModel.eliminar(prof)
                  }
                  .setNegativeButton(resources.getString(R.string.cancelar), null)
                  .show()
          }
        }
            binding.btnAddProfe.setOnClickListener{
            val directions = ProfesorFragmentDirections.actionNavProfesorToProfesorOperaFragment(null)
            findNavController().navigate(directions)
        }

    }
        override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

package pe.cibertec.edu.sistemamatricula.ui.alumnos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pe.cibertec.edu.sistemamatricula.ProyectoApplication
import pe.cibertec.edu.sistemamatricula.R
import pe.cibertec.edu.sistemamatricula.adapter.AlumnoAdapter
import pe.cibertec.edu.sistemamatricula.adapter.ProfesorAdapter
import pe.cibertec.edu.sistemamatricula.databinding.FragmentAlumnosBinding
import pe.cibertec.edu.sistemamatricula.databinding.FragmentProfesorBinding
import pe.cibertec.edu.sistemamatricula.viewmodel.ViewModelFactory

class AlumnosFragment : Fragment() {

    private var _binding: FragmentAlumnosBinding? = null
    private lateinit var alumnoAdapter : AlumnoAdapter

    val binding get() = _binding!!
    private val alumnosViewModel : AlumnosViewModel by viewModels {
        ViewModelFactory(repository = (requireActivity().application as ProyectoApplication).repoAlumno)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlumnosBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alumnosViewModel.listaAlumnos.observe(viewLifecycleOwner) { listaAlumnos ->
            binding.rvAlumno.adapter = AlumnoAdapter(listaAlumnos, { alu ->

                val directions = AlumnosFragmentDirections.actionNavAlumnosToAlumnosOpeFragment(alu)
                findNavController().navigate(directions)
            }
            ) { alu ->
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle(resources.getString(R.string.confirmacion))
                    .setMessage(resources.getString(R.string.mensajeeliminaralu, alu.nombre))
                    .setPositiveButton(resources.getString(R.string.aceptar)) { _, _ ->

                        alumnosViewModel.eliminar(alu)
                    }
                    .setNegativeButton(resources.getString(R.string.cancelar), null)
                    .show()
            }
        }
        binding.btnAddAlumno.setOnClickListener{
            val directions = AlumnosFragmentDirections.actionNavAlumnosToAlumnosOpeFragment(null)
            findNavController().navigate(directions)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
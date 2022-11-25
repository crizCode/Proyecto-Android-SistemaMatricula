package pe.cibertec.edu.sistemamatricula.ui.profesor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import pe.cibertec.edu.sistemamatricula.ProyectoApplication
import pe.cibertec.edu.sistemamatricula.R
import pe.cibertec.edu.sistemamatricula.databinding.FragmentProfesorOperaBinding
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor
import pe.cibertec.edu.sistemamatricula.viewmodel.ViewModelFactory

class ProfesorOperaFragment : Fragment() {

    private var _binding: FragmentProfesorOperaBinding? = null
    val binding get() = _binding!!

    val profesorViewModel : ProfesorViewModel by viewModels {
        ViewModelFactory(repository2 = (requireActivity().application as ProyectoApplication).repoProfesor)
    }

    private val args by  navArgs<ProfesorOperaFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfesorOperaBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profesor = args.profesor
        if(profesor != null){

            binding.txtNom.editText?.setText(profesor.nombre)
            binding.txtCorreo.editText?.setText(profesor.correo)
            binding.txtArea.editText?.setText(profesor.area)
            binding.txtEstado.editText?.setText(profesor.estado)


            binding.btnActualizar.visibility = View.VISIBLE
            binding.btnActualizar.setOnClickListener{
                // Update
                binding.txtNom.error = null
                binding.txtCorreo.error = null
                binding.txtArea.error = null
                binding.txtEstado.error = null


                val nombre = binding.txtNom.editText?.text.toString()
                val correo = binding.txtCorreo.editText?.text.toString()
                val area = binding.txtArea.editText?.text.toString()
                val estado = binding.txtEstado.editText?.text.toString()

                if(nombre.isEmpty()){
                    binding.txtNom.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(correo.isEmpty()){
                    binding.txtCorreo.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(area == null){
                    binding.txtArea.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(estado == null){
                    binding.txtEstado.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }
                profesor.nombre = nombre
                profesor.correo = correo
                profesor.area = area
                profesor.estado = estado

                profesorViewModel.actualizar(profesor)
                findNavController().popBackStack()
            }

            } else {
                // INSERTAR
                binding.btnGuardar.visibility = View.VISIBLE
                binding.btnGuardar.setOnClickListener {
                    binding.txtNom.error = null
                    binding.txtCorreo.error = null
                    binding.txtArea.error = null
                    binding.txtEstado.error = null

                    val nombre = binding.txtNom.editText?.text.toString()
                    val correo = binding.txtCorreo.editText?.text.toString()
                    val area = binding.txtArea.editText?.text.toString()
                    val estado = binding.txtEstado.editText?.text.toString()

                    if(nombre.isEmpty()){
                        binding.txtNom.error = resources.getString(R.string.camporequerido)
                        return@setOnClickListener
                    }

                    if(correo.isEmpty()){
                        binding.txtCorreo.error = resources.getString(R.string.camporequerido)
                        return@setOnClickListener
                    }

                    if(area == null){
                        binding.txtArea.error = resources.getString(R.string.camporequerido)
                        return@setOnClickListener
                    }

                    if(estado == null){
                        binding.txtEstado.error = resources.getString(R.string.camporequerido)
                        return@setOnClickListener
                    }

                    val profNuevo = Profesor(nombre = nombre, correo = correo, area = area, estado = estado)
                    profesorViewModel.insertar(profNuevo)
                    findNavController().popBackStack()
                }
            }

        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
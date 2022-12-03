package pe.cibertec.edu.sistemamatricula.ui.alumnos
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import pe.cibertec.edu.sistemamatricula.ProyectoApplication
import pe.cibertec.edu.sistemamatricula.R
import pe.cibertec.edu.sistemamatricula.databinding.FragmentAlumnosOpeBinding
import pe.cibertec.edu.sistemamatricula.roon.alumno.Alumno
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor
import pe.cibertec.edu.sistemamatricula.viewmodel.ViewModelFactory

class AlumnosOpeFragment : Fragment() {

    private var _binding: FragmentAlumnosOpeBinding? = null
    val binding get() = _binding!!

    val alumnoViewModel : AlumnosViewModel by viewModels {
        ViewModelFactory(repository = (requireActivity().application as ProyectoApplication).repoAlumno)
    }

    private val args by  navArgs<AlumnosOpeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlumnosOpeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val alumno = args.alumno
        if(alumno != null){

            binding.txtCod.editText?.setText(alumno.codigo)
            binding.txtNom.editText?.setText(alumno.nombre)
            binding.txtCelular.editText?.setText(alumno.celular)
            binding.txtCorreo.editText?.setText(alumno.correo)
            binding.txtCiclo.editText?.setText(alumno.ciclo)
            binding.txtEstado.editText?.setText(alumno.estado)


            binding.btnActualizar.visibility = View.VISIBLE
            binding.btnActualizar.setOnClickListener{
                // Update
                binding.txtCod.error = null
                binding.txtNom.error = null
                binding.txtCelular.error = null
                binding.txtCorreo.error = null
                binding.txtCiclo.error = null
                binding.txtEstado.error = null


                val codigo = binding.txtCod.editText?.text.toString()
                val nombre = binding.txtNom.editText?.text.toString()
                val celular = binding.txtCelular.editText?.text.toString()
                val correo = binding.txtCorreo.editText?.text.toString()
                val ciclo = binding.txtCiclo.editText?.text.toString()
                val estado = binding.txtEstado.editText?.text.toString()

                if(codigo.isEmpty()){
                    binding.txtCod.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(nombre.isEmpty()){
                    binding.txtNom.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(celular.isEmpty()){
                    binding.txtCelular.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(correo.isEmpty()){
                    binding.txtCorreo.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(ciclo == null){
                    binding.txtCiclo.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(estado == null){
                    binding.txtEstado.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }
                alumno.codigo = codigo
                alumno.nombre = nombre
                alumno.celular= celular
                alumno.correo = correo
                alumno.ciclo = ciclo
                alumno.estado = estado

                alumnoViewModel.actualizar(alumno)
                findNavController().popBackStack()
            }

        } else {
            // INSERTAR
            binding.btnGuardar.visibility = View.VISIBLE
            binding.btnGuardar.setOnClickListener {
                binding.txtCod.error = null
                binding.txtNom.error = null
                binding.txtCelular.error = null
                binding.txtCorreo.error = null
                binding.txtCiclo.error = null
                binding.txtEstado.error = null


                val codigo = binding.txtCod.editText?.text.toString()
                val nombre = binding.txtNom.editText?.text.toString()
                val celular = binding.txtCelular.editText?.text.toString()
                val correo = binding.txtCorreo.editText?.text.toString()
                val ciclo = binding.txtCiclo.editText?.text.toString()
                val estado = binding.txtEstado.editText?.text.toString()

                if(codigo.isEmpty()){
                    binding.txtCod.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(nombre.isEmpty()){
                    binding.txtNom.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(celular.isEmpty()){
                    binding.txtCelular.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(correo.isEmpty()){
                    binding.txtCorreo.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(ciclo.isEmpty()){
                    binding.txtCiclo.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                if(estado.isEmpty()){
                    binding.txtEstado.error = resources.getString(R.string.camporequerido)
                    return@setOnClickListener
                }

                val alumNuevo = Alumno(codigo = codigo, nombre = nombre, celular = celular, correo = correo, ciclo = ciclo, estado = estado)
                alumnoViewModel.insertar(alumNuevo)
                findNavController().popBackStack()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
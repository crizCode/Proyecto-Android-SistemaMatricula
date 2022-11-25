package pe.cibertec.edu.sistemamatricula.adapter

import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.edu.sistemamatricula.databinding.ItemAlumnoBinding
import pe.cibertec.edu.sistemamatricula.databinding.ItemProfesorBinding
import pe.cibertec.edu.sistemamatricula.roon.alumno.Alumno
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor


class AlumnoViewHolder(private val binding: ItemAlumnoBinding): RecyclerView.ViewHolder(binding.root){

    fun cargaDatos(alumno: Alumno){
        binding.txtCodigo.text = alumno.codigo
        binding.txtNombre.text = alumno.nombre
        binding.txtCelular.text = alumno.celular
        binding.txtMail.text = alumno.correo
        binding.txtCiclo.text = alumno.ciclo
        binding.txtEstad.text = alumno.estado
    }

}
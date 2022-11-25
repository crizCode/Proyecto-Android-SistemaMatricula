package pe.cibertec.edu.sistemamatricula.adapter

import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.edu.sistemamatricula.databinding.ItemProfesorBinding
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor


class ProfesorViewHolder(private val binding: ItemProfesorBinding): RecyclerView.ViewHolder(binding.root){

    fun cargaDatos(profesor: Profesor){
        binding.txtNom.text = profesor.nombre
        binding.txtCorreo.text = profesor.correo
        binding.txtArea.text = profesor.area
        binding.txtEstado.text = profesor.estado
    }

}
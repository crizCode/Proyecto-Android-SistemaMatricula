package pe.cibertec.edu.sistemamatricula.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import pe.cibertec.edu.sistemamatricula.databinding.ItemAlumnoBinding
import pe.cibertec.edu.sistemamatricula.roon.alumno.Alumno

class AlumnoAdapter (val listaAlumnos: List<Alumno>, val onClick:(Alumno) -> Unit, val onClickLong:(Alumno) -> Unit): Adapter<AlumnoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoViewHolder {
        val binding = ItemAlumnoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlumnoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        val alumno = listaAlumnos[position]
        holder.cargaDatos(alumno)
        holder.itemView.setOnClickListener {
            onClick(alumno)
        }
        holder.itemView.setOnLongClickListener{
            onClickLong(alumno)
            true
        }
    }

    override fun getItemCount(): Int {
        return listaAlumnos.size
    }
}


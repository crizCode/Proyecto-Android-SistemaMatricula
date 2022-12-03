package pe.cibertec.edu.sistemamatricula.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import pe.cibertec.edu.sistemamatricula.databinding.ItemProfesorBinding
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor

class ProfesorAdapter(val listaProfesores: List<Profesor>, val onClick:(Profesor) -> Unit, val onClickLong:(Profesor) -> Unit): Adapter<ProfesorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfesorViewHolder {
        val binding = ItemProfesorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfesorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfesorViewHolder, position: Int) {
        val profesor = listaProfesores[position]
        holder.cargaDatos(profesor)
        holder.itemView.setOnClickListener {
            onClick(profesor)
        }
        holder.itemView.setOnLongClickListener{
            onClickLong(profesor)
            true
        }
    }

    override fun getItemCount(): Int {
        return listaProfesores.size
    }

}


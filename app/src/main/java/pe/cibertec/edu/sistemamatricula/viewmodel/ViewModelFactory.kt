package pe.cibertec.edu.sistemamatricula.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import pe.cibertec.edu.sistemamatricula.repository.AlumnoRepository
import pe.cibertec.edu.sistemamatricula.repository.ProfesorRepository
import pe.cibertec.edu.sistemamatricula.ui.alumnos.AlumnosViewModel
import pe.cibertec.edu.sistemamatricula.ui.profesor.ProfesorViewModel

class ViewModelFactory(private val repository: AlumnoRepository? = null,private val repository2: ProfesorRepository? = null): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AlumnosViewModel::class.java)){
            return AlumnosViewModel(repository!!) as T
        } else if(modelClass.isAssignableFrom(ProfesorViewModel::class.java)){
            return ProfesorViewModel(repository2!!) as T
        }

        throw IllegalArgumentException("No corresponde  ninguna clase viewmodel")
    }


}
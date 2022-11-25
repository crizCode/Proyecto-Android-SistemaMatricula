package pe.cibertec.edu.sistemamatricula.ui.alumnos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.cibertec.edu.sistemamatricula.repository.AlumnoRepository
import pe.cibertec.edu.sistemamatricula.roon.alumno.Alumno


class AlumnosViewModel(private  val repositorio: AlumnoRepository): ViewModel() {

    val listaAlumnos: LiveData<List<Alumno>> = repositorio.todosLosAlumnos.asLiveData()

    fun insertar(alumno: Alumno){
        viewModelScope.launch {
            repositorio.insertar(alumno)
        }
    }

    fun actualizar(alumno: Alumno){
        viewModelScope.launch {
            repositorio.update(alumno)
        }
    }

    fun eliminar(alumno: Alumno){
        viewModelScope.launch {
            repositorio.delete(alumno)
        }
    }

}
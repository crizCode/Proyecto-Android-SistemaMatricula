package pe.cibertec.edu.sistemamatricula.ui.profesor

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import pe.cibertec.edu.sistemamatricula.repository.ProfesorRepository
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor

class ProfesorViewModel (private  val repositorio: ProfesorRepository): ViewModel() {

    val listaProfesores: LiveData<List<Profesor>> = repositorio.todosLosProfesores.asLiveData()

    fun insertar(profesor: Profesor){
        viewModelScope.launch {
            repositorio.insertar(profesor)
        }
    }

    fun actualizar(profesor: Profesor){
        viewModelScope.launch {
            repositorio.update(profesor)
        }
    }

    fun eliminar(profesor: Profesor){
        viewModelScope.launch {
            repositorio.delete(profesor)
        }
    }

}
package pe.cibertec.edu.sistemamatricula.repository

import kotlinx.coroutines.flow.Flow
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor
import pe.cibertec.edu.sistemamatricula.roon.profesor.ProfesorDao

class ProfesorRepository (private  val dao: ProfesorDao){

    val todosLosProfesores: Flow<List<Profesor>> = dao.getProfesores()
    val id = dao.get(id = 0)

    suspend fun insertar(profesor: Profesor){
        dao.insert(profesor)
    }
    suspend fun update(profesor: Profesor){
        dao.update(profesor)
    }
    suspend fun delete(profesor: Profesor){
        dao.delete(profesor)
    }
}


package pe.cibertec.edu.sistemamatricula.repository

import kotlinx.coroutines.flow.Flow
import pe.cibertec.edu.sistemamatricula.roon.alumno.Alumno
import pe.cibertec.edu.sistemamatricula.roon.alumno.AlumnoDao

class AlumnoRepository (private  val dao: AlumnoDao){

    val todosLosAlumnos: Flow<List<Alumno>> = dao.getAlumnos()
    val id = dao.get(id = 0)

    suspend fun insertar(alumno: Alumno){
        dao.insert(alumno)
    }
    suspend fun update(alumno: Alumno){
        dao.update(alumno)
    }
    suspend fun delete(alumno: Alumno){
        dao.delete(alumno)
    }
}


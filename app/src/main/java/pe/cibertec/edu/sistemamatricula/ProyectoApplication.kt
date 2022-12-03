package pe.cibertec.edu.sistemamatricula

import android.app.Application
import pe.cibertec.edu.sistemamatricula.data.DataBase
import pe.cibertec.edu.sistemamatricula.repository.AlumnoRepository
import pe.cibertec.edu.sistemamatricula.repository.ProfesorRepository


class ProyectoApplication:Application() {
    val basedatos by lazy { DataBase.getInstance(this) }
    val repoAlumno by lazy { AlumnoRepository(basedatos.AlumnoDao()) }
    val repoProfesor by lazy { ProfesorRepository(basedatos.ProfesorDao()) }

}
package pe.cibertec.edu.sistemamatricula.roon.alumno

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao {
    @Query(value = "SELECT * FROM tbl_alumno")
    fun getAlumnos() : Flow<List<Alumno>>

    @Query("SELECT * FROM tbl_alumno WHERE id = :id")
    fun get(id: Int): LiveData<Alumno>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alumno: Alumno)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(alumno: Alumno)

    @Delete
    suspend fun delete(alumno: Alumno)

}
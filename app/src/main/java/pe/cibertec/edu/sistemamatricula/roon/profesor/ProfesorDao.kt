package pe.cibertec.edu.sistemamatricula.roon.profesor

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfesorDao {
    @Query(value = "SELECT * FROM tbl_profesor ORDER BY nom_prod ASC")
    fun getProductos() : Flow<List<Profesor>>

    @Query("SELECT * FROM tbl_profesor WHERE id = :id")
    fun get(id: Int): LiveData<Profesor>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profesor: Profesor)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(profesor: Profesor)

    @Delete
    suspend fun delete(profesor: Profesor)

}
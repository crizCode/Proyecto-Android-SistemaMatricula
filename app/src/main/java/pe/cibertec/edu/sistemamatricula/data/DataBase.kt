
package pe.cibertec.edu.sistemamatricula.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.cibertec.edu.sistemamatricula.roon.alumno.Alumno
import pe.cibertec.edu.sistemamatricula.roon.alumno.AlumnoDao
import pe.cibertec.edu.sistemamatricula.roon.profesor.Profesor
import pe.cibertec.edu.sistemamatricula.roon.profesor.ProfesorDao

@Database(entities = [Profesor::class,Alumno::class], version = 1  )
abstract class DataBase: RoomDatabase(){
    abstract fun ProfesorDao() : ProfesorDao
    abstract fun AlumnoDao() : AlumnoDao

    companion object{

        private var ISNTANCE : DataBase? = null

        fun getInstance(context: Context) : DataBase {

            return ISNTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    DataBase::class.java,"bd_matricula").build()
                ISNTANCE = instance
                instance
            }
        }

    }

}

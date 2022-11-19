
package pe.cibertec.edu.sistemamatricula.roon.profesor

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profesor::class], version = 1 )
abstract class DataBase: RoomDatabase(){
    abstract fun ProfesorDao() : ProfesorDao

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

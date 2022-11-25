package pe.cibertec.edu.sistemamatricula.roon.profesor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tbl_profesor")
class Profesor (@PrimaryKey(autoGenerate = true) @ColumnInfo(name ="id") val id: Int = 0,
                @ColumnInfo(name ="nom_prof") var nombre: String,
                @ColumnInfo(name ="mail_prof") var correo: String,
                @ColumnInfo(name ="area_prof") var area: String,
                @ColumnInfo(name ="estado_prof") var estado: String): Serializable


package pe.cibertec.edu.sistemamatricula.roon.alumno

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tbl_alumno")
class Alumno (@PrimaryKey(autoGenerate = true) @ColumnInfo(name ="id") val id: Int = 0,
              @ColumnInfo(name ="cod_alum") var codigo: String,
              @ColumnInfo(name ="nom_alum") var nombre: String,
              @ColumnInfo(name ="cel_alum") var celular: String,
              @ColumnInfo(name ="mail_alum") var correo: String,
              @ColumnInfo(name ="ciclo_alum") var ciclo: String,
              @ColumnInfo(name ="estado") var estado: String): Serializable


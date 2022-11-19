package pe.cibertec.edu.sistemamatricula.roon.profesor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_profesor")
class Profesor (@PrimaryKey(autoGenerate = true) @ColumnInfo(name ="id") val id: Int,
                @ColumnInfo(name ="nom_prof") val nombre: String,
                @ColumnInfo(name ="cod_prof") val codigo: String,
                @ColumnInfo(name ="can_prof") val cantidad: Int)


package pe.cibertec.edu.sistemamatricula.ui.alumnos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlumnosViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is alumnos Fragment"
    }
    val text: LiveData<String> = _text
}
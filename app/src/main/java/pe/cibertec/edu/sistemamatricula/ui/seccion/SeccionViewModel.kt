package pe.cibertec.edu.sistemamatricula.ui.seccion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeccionViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is seccion Fragment"
    }
    val text: LiveData<String> = _text
}
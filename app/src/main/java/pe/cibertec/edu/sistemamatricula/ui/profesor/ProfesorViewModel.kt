package pe.cibertec.edu.sistemamatricula.ui.profesor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfesorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is profesor Fragment"
    }
    val text: LiveData<String> = _text
}
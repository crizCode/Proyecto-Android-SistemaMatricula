package pe.cibertec.edu.sistemamatricula.ui.reportes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReportesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is reportes Fragment"
    }
    val text: LiveData<String> = _text
}
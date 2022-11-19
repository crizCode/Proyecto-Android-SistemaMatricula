package pe.cibertec.edu.sistemamatricula.ui.alumnos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.cibertec.edu.sistemamatricula.R

class AlumnosOpeFragment : Fragment() {

    companion object {
        fun newInstance() = AlumnosOpeFragment()
    }

    private lateinit var viewModel: AlumnosOpeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alumnos_ope, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlumnosOpeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
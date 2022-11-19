package pe.cibertec.edu.sistemamatricula
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import pe.cibertec.edu.sistemamatricula.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
//
    private lateinit var binding: ActivityLoginBinding

    companion object{
        lateinit var auth: FirebaseAuth

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

     binding = ActivityLoginBinding.inflate(layoutInflater)
     setContentView(binding.root)

        binding.login.setOnClickListener {
        val email = binding.mail.text.toString()
        val password = binding.password.text.toString()
        if(email.isNotEmpty() && password.isNotEmpty())
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
         }
}


}

/*
binding.signIn.setOnClickListener {
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }
    binding.signOut.setOnClickListener {
        auth.signOut()
        binding.userDetails.text = updateData()
    }
}

override fun onResume() {
    super.onResume()
    binding.userDetails.text = updateData()
}

private fun updateData(): String{
    return "Email : ${auth.currentUser?.email}"
}*/
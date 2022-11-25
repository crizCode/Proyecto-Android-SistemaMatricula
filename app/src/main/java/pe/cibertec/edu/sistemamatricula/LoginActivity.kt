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
                    val intent = Intent(this,MainActivity::class.java);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish()
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
}

}
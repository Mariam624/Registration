package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.registration.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linkToSignIn.setOnClickListener {
            val intent= Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val login = binding.userLogin.text.toString().trim()
//            Log.d("log_1","$login")
            val email = binding.userEmail.text.toString().trim()
            val pass = binding.userPass.text.toString().trim()


            if (login == "" || email == "" || pass == "")
                Toast.makeText(this, "Try again",Toast.LENGTH_LONG).show()
            else {
                val user=User(login, email, pass)
                val db=DbHelper(this, null )
                db.addUser(user)
                Toast.makeText(this, "User $login added",Toast.LENGTH_LONG).show()

                binding.userLogin.text.clear()
                binding.userEmail.text.clear()
                binding.userPass.text.clear()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
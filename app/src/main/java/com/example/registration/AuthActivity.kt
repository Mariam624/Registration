package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registration.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private var _binding: ActivityAuthBinding? = null
    private val binding: ActivityAuthBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.linkToSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.buttonAuth.setOnClickListener {
            val login = binding.loginAuth.text.toString().trim()
            val pass = binding.passAuth.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Try again", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)
                if (isAuth) {
                    Toast.makeText(this, "User $login Log in", Toast.LENGTH_LONG).show()
                    binding.loginAuth.text.clear()
                    binding.passAuth.text.clear()
                } else Toast.makeText(this, "User $login NOT Log in", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
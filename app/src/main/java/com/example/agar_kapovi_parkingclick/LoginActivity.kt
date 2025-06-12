package com.example.agar_kapovi_parkingclick

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val VALID_USERNAME1 = "mzagar"
        val VALID_PASSWORD1 = "1234"
        val VALID_USERNAME2 = "ekapovic"
        val VALID_PASSWORD2 = "4321"

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val usernameInput = etUsername.text.toString()
            val passwordInput = etPassword.text.toString()
            if (usernameInput == VALID_USERNAME1 && passwordInput == VALID_PASSWORD1 || usernameInput == VALID_USERNAME2 && passwordInput == VALID_PASSWORD2) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Pogrešno korisničko ime ili lozinka!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

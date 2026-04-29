package com.example.kendaraanapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = findViewById<EditText>(R.id.etUsername)
        val pass = findViewById<EditText>(R.id.etPassword)
        val btn = findViewById<Button>(R.id.btnLogin)

        btn.setOnClickListener {

            if (user.text.toString() == "Admin" && pass.text.toString() == "1234") {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

package com.example.quickjobapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signUpButton = findViewById<Button>(R.id.signup_link_btn)
        signUpButton.setOnClickListener {
            val intent = Intent (this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
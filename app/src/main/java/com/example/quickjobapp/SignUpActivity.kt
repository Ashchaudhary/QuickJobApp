package com.example.quickjobapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        /*val signup_link_btn = null
        val signin_link_btn = null
        signin_link_btn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }*/
        val signInButton = findViewById<Button>(R.id.signin_link_btn)
        signInButton.setOnClickListener {
            val intent = Intent (this, SignInActivity::class.java)
            startActivity(intent)
        }


    }
}
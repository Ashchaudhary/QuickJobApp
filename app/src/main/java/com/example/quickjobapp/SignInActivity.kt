package com.example.quickjobapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signup_link_btn = null
        signup_link_btn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

    }
}

fun Nothing?.setOnClickListener(function: () -> Unit) {


}

package com.example.quickjobapp.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.quickjobapp.R

class AddPostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)


        val navAddBtn = findViewById<Button>(R.id.post_job_btn)
        navAddBtn.setOnClickListener {
            val intent = Intent(this, AddPost2::class.java)
            startActivity(intent)

        }
        val navAddBtn2 = findViewById<Button>(R.id.read_btn)
        navAddBtn2.setOnClickListener {
            val intent = Intent(this, ViewPostActivity::class.java)
            startActivity(intent)

        }


    }

}
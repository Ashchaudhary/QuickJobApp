package com.example.quickjobapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quickjobapp.Fragments.HomeFragment
import com.example.quickjobapp.Fragments.NotificationsFragment
import com.example.quickjobapp.Fragments.ProfileFragment
import com.example.quickjobapp.Fragments.SearchFragment
class AddPostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)


        val navAddBtn = findViewById<Button>(R.id.post_job_btn)
        navAddBtn.setOnClickListener {
            val intent = Intent(this, AddPost2::class.java)
            startActivity(intent)

        }


    }
}
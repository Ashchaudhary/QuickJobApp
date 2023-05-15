package com.example.quickjobapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickjobapp.databinding.ActivityViewPostBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ViewPostActivity : AppCompatActivity() {

    private var _binding : ActivityViewPostBinding?=null
    private val binding : ActivityViewPostBinding
        get() = _binding!!



    private val LOCATION = "location"
    private val TITLE = "title"
    private val ROLE = "role"
    private val DECRIPTION = "description"
    private val SALARY = "salary"
    private val COLLECTION = "notes"
    private val DOCUMENT = "inner_notes"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityViewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



}
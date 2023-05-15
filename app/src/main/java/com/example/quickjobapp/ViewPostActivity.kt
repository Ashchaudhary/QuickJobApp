package com.example.quickjobapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickjobapp.Activities.ViewPostActivity
import com.example.quickjobapp.databinding.ActivityAddPost2Binding
import com.example.quickjobapp.databinding.ActivityViewPostBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.reflect.KProperty

private operator fun Any.setValue(viewPostActivity: ViewPostActivity, property: KProperty<*>, firebaseFirestore: FirebaseFirestore) {

}


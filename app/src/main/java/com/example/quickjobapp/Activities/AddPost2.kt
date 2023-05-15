package com.example.quickjobapp.Activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quickjobapp.Model.AddPostModel
import com.example.quickjobapp.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddPost2 : AppCompatActivity() {


    private lateinit var planetsSpinner: EditText
    private lateinit var titletxt: EditText
    private lateinit var roletxt: EditText
    private lateinit var descriptiontxt: EditText
    private lateinit var salarytxt: EditText
    private lateinit var postbtn: Button

    private lateinit var dbRef: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post2)

        planetsSpinner = findViewById(R.id.planetsSpinner)
        titletxt = findViewById(R.id.titletxt)
        roletxt = findViewById(R.id.roletxt)
        descriptiontxt = findViewById(R.id.descriptiontxt)
        salarytxt = findViewById(R.id.salarytxt)
        postbtn = findViewById(R.id.postbtn)

        dbRef = FirebaseDatabase.getInstance().getReference("post")

        postbtn.setOnClickListener {
            save()
        }





    }
    private fun save(){
        val location =  planetsSpinner.text.toString()
        val title = titletxt.text.toString()
        val role = roletxt.text.toString()
        val description = descriptiontxt.text.toString()
        val salary = salarytxt.text.toString()

        if (location.isEmpty()){
            planetsSpinner.error = "please enter the location"
        }
        if (title.isEmpty()){
            titletxt.error = "please enter the location"
        }
        if (role.isEmpty()){
            roletxt.error = "please enter the location"
        }
        if (description.isEmpty()){
            descriptiontxt.error = "please enter the description"
        }
        if (salary.isEmpty()){
            salarytxt.error = "please enter the salary"
        }
        if (location.isNotEmpty() && title.isNotEmpty() && role.isNotEmpty() && description.isNotEmpty() && salary.isNotEmpty()){
            val jobId = dbRef.push().key!!

            val jobPost = AddPostModel(jobId, location, title, role, description, salary)

            dbRef.child(jobId).setValue(jobPost)
                .addOnCompleteListener {
                    Toast.makeText(this, "post success", Toast.LENGTH_LONG).show()

                    planetsSpinner.text.clear()
                    titletxt.text.clear()
                    roletxt.text.clear()
                    descriptiontxt.text.clear()
                    salarytxt.text.clear()

                }.addOnFailureListener {
                    Toast.makeText(this, "error accorded", Toast.LENGTH_LONG).show()
                }
        }




    }


}
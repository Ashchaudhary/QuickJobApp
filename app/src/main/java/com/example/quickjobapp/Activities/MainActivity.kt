package com.example.quickjobapp.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickjobapp.Adapters.JobAdapter
import com.example.quickjobapp.Fragments.HomeFragment
import com.example.quickjobapp.Fragments.NotificationsFragment
import com.example.quickjobapp.Fragments.ProfileFragment
import com.example.quickjobapp.Fragments.SearchFragment
import com.example.quickjobapp.Model.AddPostModel
import com.example.quickjobapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var jobRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var jobArrayList : ArrayList<AddPostModel>




    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                moveToFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_search -> {
                moveToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_add_post -> {
                val intent = Intent(this, AddPostActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {
                moveToFragment(NotificationsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                moveToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true

            }
        }


        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jobRecyclerView = findViewById(R.id.jobList)
        jobRecyclerView.layoutManager = LinearLayoutManager(this)
        jobRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)
        jobArrayList = arrayListOf<AddPostModel>()
        getJobData()


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
        navView.setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)

     moveToFragment(HomeFragment())
    }

    private fun getJobData(){
        dbref = FirebaseDatabase.getInstance().getReference("post")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){

                        val job = userSnapshot.getValue(AddPostModel::class.java)
                        jobArrayList.add(job!!)
                    }

                    jobRecyclerView.adapter = JobAdapter(jobArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun moveToFragment(fragment: Fragment){

        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }
}
package com.example.quickjobapp

import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quickjobapp.Fragments.HomeFragment
import com.example.quickjobapp.Fragments.NotificationsFragment
import com.example.quickjobapp.Fragments.ProfileFragment
import com.example.quickjobapp.Fragments.SearchFragment
import com.example.quickjobapp.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    internal var selectedFragment: Fragment? = null


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                selectedFragment = HomeFragment()


            }
            R.id.nav_search -> {

                selectedFragment = SearchFragment()
            }
            R.id.nav_add_post -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {

                selectedFragment = NotificationsFragment()
            }
            R.id.nav_profile -> {

                selectedFragment = ProfileFragment()
            }
        }
        if(selectedFragment != null){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
               selectedFragment!!

            ).commit()

        }

        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)



        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        supportFragmentManager.beginTransaction().replace(
        R.id.fragment_container,
           HomeFragment()

        ).commit()
    }
}
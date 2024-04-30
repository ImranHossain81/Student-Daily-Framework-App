package com.example.studentdailyframework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.studentdailyframework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottonBar.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home_item -> replaceFragment(HomeFragment())
                R.id.profile_item -> replaceFragment(ProfileFragment())
                R.id.more_item -> replaceFragment(MoreFragment())

                else ->{
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()


    }



    private val TIME_INTERVAL: Long = 2000 // # milliseconds, desired
    private var mBackPressed: Long = 0


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // When user press back button
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            Toast.makeText(baseContext, "Press again to exit", Toast.LENGTH_SHORT).show()
        }

        mBackPressed = System.currentTimeMillis()
    }



}
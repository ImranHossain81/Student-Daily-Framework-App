package com.example.studentdailyframework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentdailyframework.databinding.ActivityAboutPageBinding
import com.example.studentdailyframework.databinding.ActivityHelpCanterBinding

class AboutPage : AppCompatActivity() {
    private lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.abut.setOnClickListener {
            startActivity(Intent(this@AboutPage, MainActivity::class.java))
            finish()
        }

    }
}
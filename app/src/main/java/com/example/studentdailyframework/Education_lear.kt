package com.example.studentdailyframework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentdailyframework.databinding.ActivityEducationLearBinding

class Education_lear : AppCompatActivity() {
    private lateinit var binding : ActivityEducationLearBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEducationLearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back2.setOnClickListener {
            startActivity(Intent(this@Education_lear, MainActivity::class.java))
            finish()
        }

        binding.admission1.setOnClickListener(){

            WebBrowser.WEBSITE_LINK="https://shorturl.at/cflyN";
            WebBrowser.WEBSITE_TITLE="একাডেমিক  জিজ্ঞাসা";
            val intent = Intent(this@Education_lear, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.admission2.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://shorturl.at/hvATV"
            WebBrowser.WEBSITE_TITLE = "SSC/HSC শেষ এখন কি করব?"
            val intent = Intent(this@Education_lear, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.admission3.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://shorturl.at/gmCY5";
            WebBrowser.WEBSITE_TITLE = "বিশ্ববিদ্যালয় ভর্তি"
            val intent = Intent(this@Education_lear, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.admission4.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://shorturl.at/nyGQT";
            WebBrowser.WEBSITE_TITLE = "ক্যারিয়ার ভাবনা"
            val intent = Intent(this@Education_lear, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

    }
}
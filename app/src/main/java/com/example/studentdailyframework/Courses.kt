package com.example.studentdailyframework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.studentdailyframework.databinding.ActivityCoursesBinding
import com.example.studentdailyframework.databinding.ActivityEducationLearBinding

class Courses : AppCompatActivity() {
    private lateinit var binding: ActivityCoursesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.admission4.setOnClickListener(){
            WebBrowser.WEBSITE_LINK = "https://www.skillsportal.gov.bd/#/"
            WebBrowser.WEBSITE_TITLE = "National Skills Portal (NSP)"
            val intent = Intent(this@Courses, WebBrowser::class.java)
            startActivity(intent)

        }

        binding.admission1.setOnClickListener(){
            WebBrowser.WEBSITE_LINK = "https://dipti.com.bd/"
            WebBrowser.WEBSITE_TITLE = "Daffodil Training Institute- DiPTi"
            val intent = Intent(this@Courses, WebBrowser::class.java)
            startActivity(intent)

        }

        binding.admission2.setOnClickListener(){
            WebBrowser.WEBSITE_LINK = "https://www.bdskills.gov.bd/"
            WebBrowser.WEBSITE_TITLE = "Bangladesh Digital Skills (BDskills)"
            val intent = Intent(this@Courses, WebBrowser::class.java)
            startActivity(intent)

        }

        binding.admission3.setOnClickListener(){
            WebBrowser.WEBSITE_LINK = "https://basis.org.bd/"
            WebBrowser.WEBSITE_TITLE = "BASIS Monthly Magazine Smart Bangladesh"
            val intent = Intent(this@Courses, WebBrowser::class.java)
            startActivity(intent)

        }



        binding.back3.setOnClickListener {
            startActivity(Intent(this@Courses, MainActivity::class.java))
            finish()
        }


    }
}
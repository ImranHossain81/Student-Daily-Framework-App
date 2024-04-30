package com.example.studentdailyframework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentdailyframework.databinding.ActivityHadisBt1Binding

class HadisBt1 : AppCompatActivity() {
    private lateinit var binding: ActivityHadisBt1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadisBt1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back1.setOnClickListener {
            startActivity(Intent(this@HadisBt1, MainActivity::class.java))
            finish()
        }

        binding.News1.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://www.hadithbd.com/quran/"
            WebBrowser.WEBSITE_TITLE = " আল-কুরআন (অনুবাদ, তাফসীর ও তিলাওয়াত)"
            val intent = Intent(this@HadisBt1, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.News2.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://www.hadithbd.com/hadith/subjectwise/detail/?sub=4"
            WebBrowser.WEBSITE_TITLE = "সালাতের সময়/ওয়াক্ত হাদীস সংখ্যা ২২ টি"
            val intent = Intent(this@HadisBt1, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.News3.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://www.hadithbd.com/hadith/subjectwise/detail/?sub=7"
            WebBrowser.WEBSITE_TITLE = "রাসুল(সা) আমাদের মতই মানুষ ছিলেন হাদিস ১১ টি"
            val intent = Intent(this@HadisBt1, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.News4.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://www.hadithbd.com/hadith/detail/?book=27&section=694"
            WebBrowser.WEBSITE_TITLE = "ফিতনা সম্পর্কিত হাদীসসমূহ ১৯ টি"
            val intent = Intent(this@HadisBt1, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.News5.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://www.hadithbd.com/hadith/subjectwise/detail/?sub=10"
            WebBrowser.WEBSITE_TITLE = "রাসুল(সা) এর উপর দরূদ সংখ্যা হাদিসঃ ৫টি"
            val intent = Intent(this@HadisBt1, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }

        binding.News6.setOnClickListener(){

            WebBrowser.WEBSITE_LINK = "https://www.hadithbd.com/hadith/subjectwise/detail/?sub=1"
            WebBrowser.WEBSITE_TITLE = "আল্লাহ কোথায় ? হাদীস সংখ্যা ৮ টি"
            val intent = Intent(this@HadisBt1, WebBrowser::class.java)
            startActivity(intent)
            finish()

        }


    }
}
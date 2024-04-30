package com.example.studentdailyframework

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.studentdailyframework.databinding.ActivityCoursesBinding
import com.example.studentdailyframework.databinding.ActivityHelpCanterBinding

class HelpCanter : AppCompatActivity() {
    private lateinit var binding: ActivityHelpCanterBinding

    private var num: String = ""
    private lateinit var back: ImageView
    private lateinit var Help1: LottieAnimationView
    private lateinit var Help2: LottieAnimationView
    private lateinit var Help3: LottieAnimationView
    private lateinit var Help4: LottieAnimationView
    private lateinit var Help5: LottieAnimationView
    private lateinit var Help6: LottieAnimationView
    private lateinit var Help7: LottieAnimationView
    private lateinit var Help8: LottieAnimationView
    private lateinit var Help9: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpCanterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back9.setOnClickListener {
            startActivity(Intent(this@HelpCanter, MainActivity::class.java))
            finish()
        }


        Help1 = findViewById(R.id.Help1)
        Help2 = findViewById(R.id.Help2)
        Help3 = findViewById(R.id.Help3)
        Help4 = findViewById(R.id.Help4)
        Help5 = findViewById(R.id.Help5)
        Help6 = findViewById(R.id.Help6)
        Help7 = findViewById(R.id.Help7)
        Help8 = findViewById(R.id.Help8)
        Help9 = findViewById(R.id.Help9)

        back = findViewById(R.id.back9)
        back.setOnClickListener {
            super.onBackPressed()
        }

        //======Helpline=============//
        binding.Help1.setOnClickListener {
            num = "999"
            callPhoneNumber()
        }
        binding.Help2.setOnClickListener {
            num = "16575"
            callPhoneNumber()
        }
        binding.Help3.setOnClickListener {
            num = "109"
            callPhoneNumber()
        }
        binding.Help4.setOnClickListener {
            num = "1098"
            callPhoneNumber()
        }
        binding.Help5.setOnClickListener {
            num = "333"
            callPhoneNumber()
        }
        binding.Help6.setOnClickListener {
            num = "106"
            callPhoneNumber()
        }
        binding.Help7.setOnClickListener {
            num = "16430"
            callPhoneNumber()
        }
        binding.Help8.setOnClickListener {
            num = "1090"
            callPhoneNumber()
        }
        binding.Help9.setOnClickListener {
            num = "16122"
            callPhoneNumber()
        }
    }

    //......call method.........//
    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneNumber()
            }
        }
    }

    fun callPhoneNumber() {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@HelpCanter,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        101
                    )
                    return
                }
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.setData(Uri.parse("tel:$num"))
                startActivity(callIntent)
            } else {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.setData(Uri.parse("tel:$num"))
                startActivity(callIntent)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

}

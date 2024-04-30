package com.example.studentdailyframework

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentdailyframework.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)

        binding.hadisBt1.setOnClickListener{
            val intent = Intent(requireContext(), HadisBt1::class.java)
            startActivity(intent)
        }

        binding.education.setOnClickListener{
            val intent = Intent(requireContext(), Education_lear::class.java)
            startActivity(intent)
        }

        binding.Courselist.setOnClickListener{
            val intent = Intent(requireContext(), Courses::class.java)
            startActivity(intent)
        }

        binding.helpcenter.setOnClickListener{
            val intent = Intent(requireContext(), HelpCanter::class.java)
            startActivity(intent)
        }

        return binding.root


        binding.genearelBt.setOnClickListener(){
            WebBrowser.WEBSITE_LINK = "https://www.bigganchinta.com/"
            WebBrowser.WEBSITE_TITLE = "জানা-অজানা বিজ্ঞান"
            val intent = Intent(requireContext(), WebBrowser::class.java)
            startActivity(intent)

        }
    }

}
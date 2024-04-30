package com.example.studentdailyframework

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import com.example.studentdailyframework.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.AboutApplication.setOnClickListener{
            val intent = Intent(requireContext(), AboutPage::class.java)
            startActivity(intent)
        }

        binding.logout.setOnClickListener {
            if (FirebaseAuth.getInstance().currentUser!=null){
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)

            }

        }


        return binding.root
    }

}
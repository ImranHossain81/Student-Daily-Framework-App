package com.example.studentdailyframework

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentdailyframework.databinding.FragmentHomeBinding
import com.example.studentdailyframework.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentMoreBinding.inflate(layoutInflater)

        binding.calculatorPage.setOnClickListener{
            val intent = Intent(requireContext(), Calculate_weight_hight::class.java)
            startActivity(intent)
        }


        return binding.root

    }

}
package com.example.pr1k

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pr1k.databinding.FragmentMainBinding
import com.example.pr1k.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container,false)

        binding.button.setOnClickListener {
            binding.textView.text=binding.editTextText.text
        }
        return binding.root
    }
}
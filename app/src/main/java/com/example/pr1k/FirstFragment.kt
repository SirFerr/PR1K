package com.example.pr1k

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pr1k.databinding.ActivityMainBinding
import com.example.pr1k.databinding.FragmentFirstBinding
import com.example.pr1k.databinding.FragmentSecondBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container,false)
        binding.button2.setOnClickListener {
            System.exit(-1)
        }
        return binding.root
    }

}
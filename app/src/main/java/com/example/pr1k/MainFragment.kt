package com.example.pr1k

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pr1k.databinding.ActivityMainBinding
import com.example.pr1k.databinding.FragmentFirstBinding
import com.example.pr1k.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun getBinding(): FragmentMainBinding {
        return binding
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container,false)
        binding.FirstButton.setOnClickListener {
            val first = FirstFragment()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment, first)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        binding.SecondButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }
        return binding.root
    }


}
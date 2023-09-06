package com.example.pr1k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pr1k.databinding.ActivityMainBinding
import com.example.pr1k.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainb: FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainb = FragmentMainBinding.
        mainb.FirstButton.setOnClickListener {
            val first = FirstFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, first)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}
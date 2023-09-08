package com.example.pr1k.UI.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pr1k.R
import com.example.pr1k.UI.ViewModel.ItemVM
import com.example.pr1k.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var mItemVM: ItemVM;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        mItemVM = ViewModelProvider(this).get(ItemVM::class.java)

        val adapter = ListAdapter()



        binding.resyclerView.adapter = adapter
        binding.resyclerView.layoutManager = LinearLayoutManager(requireContext())
        mItemVM.getAllData.observe(viewLifecycleOwner, Observer { item ->
            adapter.setData(item)
        })


        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_addFragment)
        }

        return binding.root
    }

}
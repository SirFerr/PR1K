package com.example.pr1k.UI.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pr1k.R
import com.example.pr1k.UI.View.Adapters.ListAdapter
import com.example.pr1k.UI.ViewModel.ItemVM
import com.example.pr1k.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var mItemVM: ItemVM;


    override fun onResume() {
        super.onResume()
        val adapter = ListAdapter()
        binding.resyclerView.layoutManager = LinearLayoutManager(requireContext())
        mItemVM.getAllData.observe(viewLifecycleOwner) { item ->
            adapter.setData(item)
        }
        adapter.notifyDataSetChanged()

        binding.resyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        mItemVM = ViewModelProvider(this).get(ItemVM::class.java)






        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_addFragment)
        }

        return binding.root
    }

}
package com.example.pr1k.UI.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pr1k.Data.Item.Item
import com.example.pr1k.databinding.FragmentDateListBinding


class DateListFragment : Fragment() {

    private lateinit var binding: FragmentDateListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDateListBinding.inflate(inflater, container, false)

        val adapter = ListAdapter()


        var tempList: MutableList<Item> = ArrayList()

        for (i: Int in 0..10) {
            tempList.add(Item(i, "${i}"))
        }

        Log.d("array", tempList.toString())
        adapter.setData(tempList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }


}
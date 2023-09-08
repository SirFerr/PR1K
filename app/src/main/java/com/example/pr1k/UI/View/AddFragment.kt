package com.example.pr1k.UI.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pr1k.Data.Item.Item
import com.example.pr1k.UI.ViewModel.ItemVM
import com.example.pr1k.databinding.FragmentAddBinding


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var mItemVM: ItemVM;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        mItemVM = ViewModelProvider(this).get(ItemVM::class.java)

        binding.add.setOnClickListener {
            var tempName = binding.editText.text.toString()
            if (tempName.isEmpty()) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
            } else {
                var item = Item(0, tempName)
                mItemVM.addItem(item)
                findNavController().popBackStack()
            }

        }


        return binding.root
    }
}
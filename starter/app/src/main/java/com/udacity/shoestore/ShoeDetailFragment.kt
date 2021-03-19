package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.cancel.setOnClickListener { view: View ->
            view.findNavController().navigateUp()
        }

        binding.save.setOnClickListener { view: View ->
            view.findNavController().navigateUp()
        }

        return binding.root
    }
}
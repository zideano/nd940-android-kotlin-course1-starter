package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoeListViewModel = viewModel

        binding.shoe = Shoe("",0.0,"","")

        binding.lifecycleOwner = this

        binding.create.setOnClickListener { view: View ->
            view.findNavController().navigateUp()
        }

        viewModel.isShoeAdded.observe(viewLifecycleOwner, { isAdded ->
            if (isAdded) {
                findNavController().navigateUp()
                viewModel.clear()
            }
        })

        return binding.root
    }
}
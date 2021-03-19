package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsScreenBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeListViewModel
    private lateinit var layout: LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.addShoe.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragment2ToShoeDetailFragment())
        }

        // do I need this?
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel

        layout = binding.shoeListLayout

        binding.lifecycleOwner = this

        viewModel.shoes.observe(viewLifecycleOwner, Observer {shoeList ->
            // this is where you add the views programmatically
            shoeList.forEach { shoe ->
                val inflate = FragmentShoeDetailsScreenBinding.inflate(inflater, null, false)
                inflate.shoe = shoe
                binding.shoeListLayout.addView(inflate.root)
            }
        })

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }
}
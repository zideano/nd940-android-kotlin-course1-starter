package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes : LiveData<List<Shoe>>
        get() = _shoes

    init {
        _shoes.value = listOf(
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
            Shoe("Nike", 4.5, "Nike", "Air max 360", listOf()),
        )
    }
}
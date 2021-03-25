package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes : LiveData<MutableList<Shoe>>
        get() = _shoes

    private val _isShoeAdded = MutableLiveData<Boolean>()
    val isShoeAdded : LiveData<Boolean>
        get() = _isShoeAdded

    init {
        _shoes.value = mutableListOf()
        _isShoeAdded.value = false
    }

    fun clear() {
        _isShoeAdded.value = false
    }

    fun addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
        _isShoeAdded.value = true
    }
}
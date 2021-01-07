package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel {

    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes: LiveData<List<Shoe>>
        get() = _listOfShoes

}

package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel: ViewModel() {

    private val shoeList: MutableList<Shoe> = mutableListOf()

    private val _listOfShoes = MutableLiveData<List<Shoe>>()
    val listOfShoes: LiveData<List<Shoe>>
        get() = _listOfShoes

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _listOfShoes.value = shoeList

        Timber.d("shoeList: $shoeList")
    }
}

package com.fasdevapps.beethovenbreedfinder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fasdevapps.beethovenbreedfinder.model.Dog
import com.fasdevapps.beethovenbreedfinder.repository.DogRepository
import kotlinx.coroutines.launch

class DogListViewModel: ViewModel() {

    private val dogRepository = DogRepository()

    /**
     * Los métodos que editan la lista de perros estarán implementados para la lista privada y
     * mutable _dogList para respetar el encapsulamiento
     */
    private val _dogList = MutableLiveData<List<Dog>>()

    val dogList: LiveData<List<Dog>> // esta Lista privada solo implementará este método get.
        get() = _dogList

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        // ejecutar una corrutina:
        viewModelScope.launch {
            _dogList.value = dogRepository.downloadDogs()
        }
    }
}
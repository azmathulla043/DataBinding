package com.tech.databinding

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val currentRandomFruitName: LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClicked() = FakeRepository.changeCurrentRandomFruitName()

    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val _displayedEditTextContent = MutableLiveData<String>()
    val  displayedEditTextContent :MutableLiveData<String>
    get() = _displayedEditTextContent

    fun OnDisplayedEditTextContentClicked(){
        _displayedEditTextContent.value = editTextContent.value
    }

    fun OnSelectRandomEditTextFruit(){
        editTextContent.value = FakeRepository.getRandomFruitName()
    }

}


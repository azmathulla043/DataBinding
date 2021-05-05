package com.tech.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val fruitsNames:List<String> = listOf(
        "Apple","Bannana","Orange","Kiwi","Graps","Fig",
        "Pearse","starwberrys","GrossBerrys","Papaya")

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName:LiveData<String>
    get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitsNames.first()
    }
    fun getRandomFruitName():String{
        val random = Random()
        return fruitsNames[random.nextInt(fruitsNames.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
    }
}
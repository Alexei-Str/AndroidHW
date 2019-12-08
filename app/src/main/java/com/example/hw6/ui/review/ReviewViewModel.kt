package com.example.hw6.ui.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReviewViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ваше мнение важно для нас"
    }
    val text: LiveData<String> = _text
}

package com.example.hw6.ui.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessagesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Список сообщений пуст"
    }
    val text: LiveData<String> = _text
}

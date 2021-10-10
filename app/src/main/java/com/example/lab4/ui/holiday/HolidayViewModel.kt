package com.example.lab4.ui.holiday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HolidayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "HOLIDAYS"
    }
    val text: LiveData<String> = _text
}
package com.example.navitest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navitest.R

class HomeViewModel : ViewModel() {

    private val image = MutableLiveData<Int>().apply {
        value = R.drawable.felix
    }
    val player: LiveData<Int> = image
}
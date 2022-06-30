package com.example.navitest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navitest.R

class HomeViewModel : ViewModel() {

    private val _posi_image = MutableLiveData<Int>()
    val posi_image: LiveData<Int> = _posi_image

    private val image = MutableLiveData<Int>().apply {
        value = R.drawable.felix
    }
    val felix: LiveData<Int> = image

    private val _image2 = MutableLiveData(R.drawable.griezmann)
    val griezmann: LiveData<Int> = _image2


}
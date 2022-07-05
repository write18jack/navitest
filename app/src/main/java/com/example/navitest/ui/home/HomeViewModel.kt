package com.example.navitest.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.navitest.R
import com.example.navitest.model.model.User
import com.example.navitest.model.repository.IUserRepository
import com.example.navitest.model.repository.UserRepository

class HomeViewModel : ViewModel() {

    private val repository: IUserRepository = UserRepository.getInstance()

    private val _posiId = MutableLiveData<Int>()
    fun setPosiId(pp: Int){
        Log.d("TAG",  "id HomeViewModel: $pp")
        _posiId.value = pp
    }
    val posiId: LiveData<Int> = _posiId

    private val _userId = MutableLiveData<String>()
    fun setUserId(item: String){
        _userId.value = item
    }
    val user: LiveData<User> = Transformations.switchMap(_userId){ userId ->
        repository.getUser(userId)
    }

}
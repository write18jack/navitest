package com.example.navitest.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.navitest.model.model.User
import com.example.navitest.model.repository.IUserRepository
import com.example.navitest.model.repository.UserRepository

class HomeViewModel : ViewModel() {

    private val repository: IUserRepository = UserRepository.getInstance()

    private val _posiId = MutableLiveData<Int>()
    fun setPosiId(pp: Int){
        Log.d("TAG",  "HomeViewModel _posiId: $pp")
        _posiId.value = pp
    }
    //val posiId: LiveData<Int> = _posiId
    private val _lst = MutableLiveData<Int>()
    private val _rst = MutableLiveData<Int>()

    val lst:LiveData<Int> = _lst
    val rst:LiveData<Int> = _rst

    private val _userId = MutableLiveData<String>()
    fun setUserId(item: String){
        Log.d("TAG",  "HomeViewModel setUserId: $item")
        _userId.value = item
    }

    private val user: LiveData<User> = Transformations.switchMap(_userId){ userId ->
        repository.getUser(userId)
    }
    private val playerId:LiveData<Int> = user.map {user ->
        user.iconId
    }
    private fun setLst(x:Int){
        Log.d("TAG",  "HomeViewModel setLst: $x")
        _lst.value = x
    }
    private fun setRst(x:Int){
        Log.d("TAG",  "HomeViewModel setRst: $x")
        _rst.value = x
    }

    fun positionSelect(){
        if (_posiId.value==1){
            Log.d("TAG",  "HomeViewModel _posiId1: $_posiId")
            playerId.value?.let { setLst(it) }
            //_rst.value =
        }else if (_posiId.value==2){
            Log.d("TAG",  "HomeViewModel _posiId2: $_posiId")
            playerId.value?.let { setRst(it) }
            //_rst.value = playerId.value
        }
    }


}
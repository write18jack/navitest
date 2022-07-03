package com.example.navitest.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.navitest.model.model.User
import com.example.navitest.model.model.UserBuilder

class LocalUserDataSource {

    private val userMap: Map<String, User>

    init {
        val builder = UserBuilder()

        val user1 = builder.setId("1")
            .setIconId(1)
            .build()

        val user2 = builder.setId("2")
            .setIconId(2)
            .build()

        userMap = mutableMapOf<String, User>().apply {
            this[user1.id] = user1
            this[user2.id] = user2
        }
    }

    fun getUser(userId: String): LiveData<User>{
        val user = userMap[userId] ?: UserBuilder().build()
        return  MutableLiveData<User>().apply {
            postValue(user)
        }
    }

}
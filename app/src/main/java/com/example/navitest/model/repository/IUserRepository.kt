package com.example.navitest.model.repository

import androidx.lifecycle.LiveData
import com.example.navitest.model.model.User

interface IUserRepository {
    fun getUser(userId: String): LiveData<User>
}
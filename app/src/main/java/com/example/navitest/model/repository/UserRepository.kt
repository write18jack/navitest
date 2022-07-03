package com.example.navitest.model.repository

import androidx.lifecycle.LiveData
import com.example.navitest.model.LocalUserDataSource
import com.example.navitest.model.model.User

class UserRepository : IUserRepository{

    private val localUserDataSource = LocalUserDataSource()

    override fun getUser(userId: String): LiveData<User> {
        return localUserDataSource.getUser(userId)
    }

    /*override fun getPosition(posiId: String): LiveData<User> {
                               //ここで統一させる（先に格納できるの？）==> 無理だった
        return localUserDataSource.getUser(posiId)
    }*/

    companion object{
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(): UserRepository{
            return instance ?: synchronized(this){
                instance ?: UserRepository().also {
                    instance = it
                }
            }
        }
    }
}
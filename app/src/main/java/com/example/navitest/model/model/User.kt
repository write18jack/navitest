package com.example.navitest.model.model

data class User(
    val id: String,
    val iconId: Int
)

class UserBuilder{

    //初期化時の値
    private var mId: String = ""
    private var mIconId: Int = 0

    fun setId(id: String): UserBuilder{
        mId = id
        return this
    }

    fun setIconId(iconId: Int): UserBuilder {
        mIconId = iconId
        return this
    }

    fun build(): User{
        return User(mId, mIconId)
    }
}
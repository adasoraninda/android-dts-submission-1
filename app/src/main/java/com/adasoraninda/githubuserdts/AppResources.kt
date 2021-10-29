package com.adasoraninda.githubuserdts

import android.content.Context

class AppResources(
    private val context: Context
) {

    fun getListUser(): List<User> {
        val users = mutableListOf<User>()
        val usernames = context.resources.getStringArray(R.array.username)
        val listAvatar = context.resources.obtainTypedArray(R.array.avatar)

        usernames.forEachIndexed { index, _ ->
            users.add(
                User(
                    avatar = listAvatar.getResourceId(index, 0),
                    username = usernames[index]
                )
            )
        }

        listAvatar.recycle()
        return users
    }

}
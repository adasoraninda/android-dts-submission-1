package com.adasoraninda.githubuserdts.data

import android.content.Context
import com.adasoraninda.githubuserdts.R

class AppResources(private val context: Context) {

    fun getListUser(): List<User> {
        val users = mutableListOf<User>()

        val usernames = context.resources.getStringArray(R.array.username)
        val names = context.resources.getStringArray(R.array.name)
        val listAvatar = context.resources.obtainTypedArray(R.array.avatar)

        usernames.forEachIndexed { index, _ ->
            users.add(
                User(
                    avatar = listAvatar.getResourceId(index, 0),
                    username = usernames[index],
                    name = names[index]
                )
            )
        }

        listAvatar.recycle()

        return users
    }

}
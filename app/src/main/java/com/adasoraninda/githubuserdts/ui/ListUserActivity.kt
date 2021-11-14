package com.adasoraninda.githubuserdts.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adasoraninda.githubuserdts.R
import com.adasoraninda.githubuserdts.common.ListUserAdapter
import com.adasoraninda.githubuserdts.data.AppResources
import com.adasoraninda.githubuserdts.data.User

class ListUserActivity : AppCompatActivity() {

    private var listUsers: RecyclerView? = null

    private var appResources: AppResources? = null

    private val listUserAdapter = ListUserAdapter(this::navigateToDetailUser)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        listUsers = findViewById(R.id.list_users)

        appResources = AppResources(this)

        initListUsers()

        listUserAdapter.users = appResources?.getListUser() ?: emptyList()
    }

    private fun initListUsers() {
        listUsers?.layoutManager = LinearLayoutManager(this)
        listUsers?.adapter = listUserAdapter
        listUsers?.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        listUsers?.setHasFixedSize(true)
    }

    private fun navigateToDetailUser(user: User?) {
        val intent = Intent(this, DetailUserActivity::class.java)
        intent.putExtra(DetailUserActivity.EXTRA_USER, user)
        startActivity(intent)
    }

}
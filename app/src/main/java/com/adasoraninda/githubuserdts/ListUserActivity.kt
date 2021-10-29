package com.adasoraninda.githubuserdts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ListUserActivity : AppCompatActivity() {
    private var imageUser: ImageView? = null
    private var textUser: TextView? = null
    private var layoutItemUser: View? = null

    private var appResources: AppResources? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        imageUser = findViewById(R.id.image_user)
        textUser = findViewById(R.id.text_username)
        layoutItemUser = findViewById(R.id.layout_item_user)

        appResources = AppResources(this)

        val dataUser = appResources?.getListUser()?.get(1)

        initData(dataUser)

        layoutItemUser?.setOnClickListener {
            navigateToDetailUser(dataUser)
        }
    }

    private fun initData(user: User?) {
        textUser?.text = user?.username

        imageUser?.let {
            Glide.with(this)
                .load(user?.avatar)
                .into(it)
        }
    }

    private fun navigateToDetailUser(user: User?) {
        val intent = Intent(this, DetailUserActivity::class.java)
        intent.putExtra(DetailUserActivity.KEY_USER, user)
        startActivity(intent)
    }

}
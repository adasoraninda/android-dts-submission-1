package com.adasoraninda.githubuserdts.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.adasoraninda.githubuserdts.R
import com.adasoraninda.githubuserdts.data.User
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView


class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "KEY_USER"
    }

    private var imageUser: ShapeableImageView? = null
    private var textUsername: TextView? = null
    private var textName: TextView? = null
    private var dataUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_detail_user)

        imageUser = findViewById(R.id.image_user)
        textUsername = findViewById(R.id.text_username)
        textName = findViewById(R.id.text_name)

        dataUser = intent.getParcelableExtra(EXTRA_USER) as? User

        initData(dataUser)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = dataUser?.username
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_user, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_share -> {
                shareUser(dataUser)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareUser(user: User?) {
        Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, "Share GitHub User")
            putExtra(Intent.EXTRA_TEXT, "$user")
        }.apply {
            startActivity(Intent.createChooser(this, "Send data"))
        }
    }

    private fun initData(user: User?) {
        textUsername?.text = user?.username
        textName?.text = user?.name
        imageUser?.let {
            Glide.with(this)
                .load(user?.avatar)
                .into(it)
        }
    }


}
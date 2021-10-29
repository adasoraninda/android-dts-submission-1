package com.adasoraninda.githubuserdts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class DetailUserActivity : AppCompatActivity() {
    private var imageUser: ImageView? = null
    private var textUser: TextView? = null
    private var dataUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_detail_user)

        imageUser = findViewById(R.id.image_user)
        textUser = findViewById(R.id.text_username)

        dataUser = intent.getParcelableExtra(KEY_USER) as? User

        initData(dataUser)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = dataUser?.username
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_user, menu)
        return super.onCreateOptionsMenu(menu)
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
            else -> {
                super.onOptionsItemSelected(item)
            }
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
        textUser?.text = user?.username

        imageUser?.let {
            Glide.with(this)
                .load(user?.avatar)
                .into(it)
        }
    }

    companion object {
        const val KEY_USER = "KEY_USER"
    }
}
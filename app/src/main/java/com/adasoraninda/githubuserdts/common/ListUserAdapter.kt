package com.adasoraninda.githubuserdts.common

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adasoraninda.githubuserdts.R
import com.adasoraninda.githubuserdts.data.User
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class ListUserAdapter(
    private val itemClickListener: (user: User) -> Unit
) : RecyclerView.Adapter<ListUserAdapter.UserViewHolder>() {

    var users = listOf<User>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class UserViewHolder(
        view: View,
        private val itemClickListener: (user: User) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val textUsername = itemView.findViewById<TextView>(R.id.text_username)
        private val imageUser = itemView.findViewById<ShapeableImageView>(R.id.image_user)

        fun bindData(data: User) {
            textUsername.text = data.username

            Glide.with(itemView.context)
                .load(data.avatar)
                .into(imageUser)

            itemView.setOnClickListener { itemClickListener(data) }
        }

    }

}
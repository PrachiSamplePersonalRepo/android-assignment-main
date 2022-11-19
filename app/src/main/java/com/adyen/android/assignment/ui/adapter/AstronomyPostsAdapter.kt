package com.adyen.android.assignment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adyen.android.assignment.R
import com.adyen.android.assignment.api.model.AstronomyPicture
import com.adyen.android.assignment.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.item_picture.view.*


class AstronomyPostsAdapter :
    PagedListAdapter<AstronomyPicture, AstronomyPostsAdapter.MyViewHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let { holder.bindPost(it) }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pageTitle = itemView.title
        val dateText = itemView.date_time
        val imageText = itemView.image_view

        fun bindPost(redditPost: AstronomyPicture) {
            with(redditPost) {
                pageTitle.text = pageTitle.toString()
                dateText.text = dateText.toString()
                //titleText.text = title
            }
        }
    }
}
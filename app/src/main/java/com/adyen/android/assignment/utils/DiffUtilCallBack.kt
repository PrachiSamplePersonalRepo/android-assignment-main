package com.adyen.android.assignment.utils

import androidx.recyclerview.widget.DiffUtil
import com.adyen.android.assignment.api.model.AstronomyPicture

class DiffUtilCallBack : DiffUtil.ItemCallback<AstronomyPicture>() {
    override fun areItemsTheSame(oldItem: AstronomyPicture, newItem: AstronomyPicture): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: AstronomyPicture, newItem: AstronomyPicture): Boolean {
        return oldItem.title == newItem.title
                && oldItem.date == newItem.date
                && oldItem.explanation == newItem.explanation
    }

}
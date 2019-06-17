package com.example.kittytinder.listcats.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.kittytinder.data.CatImage

/**
 * Created by Festus Kiambi on 6/17/19.
 */
class CatsDiffCallback(
    private val old: List<CatImage>,
    private val new: List<CatImage>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].id == new[newPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}
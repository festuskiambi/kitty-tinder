package com.example.kittytinder.listcats.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kittytinder.data.CatImage

/**
 * Created by Festus Kiambi on 6/16/19.
 */
class CatsAdapter (private var catsList :List<CatImage>) : RecyclerView.Adapter<CatsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {

    }
}
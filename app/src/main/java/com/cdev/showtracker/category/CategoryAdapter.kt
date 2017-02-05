package com.cdev.showtracker.category

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cdev.showtracker.R
import com.cdev.showtracker.model.TvShow
import kotlinx.android.synthetic.main.item_tv_show_card.view.*
import java.util.*


/**
 * Created by cdev on 05.02.2017.
 */
class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val tvShowList: ArrayList<TvShow> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_tv_show_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder?, position: Int) {
        holder?.bindTvShowItem(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    fun addData(list: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(list)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTvShowItem(tvShowItem: TvShow) {
            with(tvShowItem) {
                itemView.tvTitle.text = name
                //itemView.imgPoster.setImageResource(imagePoster)
            }
        }
    }
}
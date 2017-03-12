package com.cdev.showtracker.category

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cdev.showtracker.R
import com.cdev.showtracker.details.DetailsActivity
import com.cdev.showtracker.details.DetailsActivity.Companion.TV_SHOW_ID_KEY
import com.cdev.showtracker.model.TvShow
import com.cdev.showtracker.network.ApiConfig
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tv_show_card.view.*
import java.util.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val tvShowList: ArrayList<TvShow> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_tv_show_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder?, position: Int) {
        holder?.bindTvShowItem(tvShowList[position])
        holder?.itemView?.setOnClickListener {

            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra(TV_SHOW_ID_KEY, tvShowList[position].id)
            holder.itemView?.context?.startActivity(intent)

        }
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
                Picasso.with(itemView.context)
                        // TODO concat the IMG_BASE_URL somewhere else
                        .load(ApiConfig.IMG_BASE_URL + posterPath)
                        .into(itemView.imgPoster)
            }
        }
    }
}
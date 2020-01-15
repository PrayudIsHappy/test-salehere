package com.project.shimi.testsalehere.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.home.model.BestOffer
import kotlinx.android.synthetic.main.adapter_best_offer.view.*

class BestOfferAdapter : RecyclerView.Adapter<BestOfferAdapter.ViewHolder>() {

    private val bestOffers = ArrayList<BestOffer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_best_offer,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = bestOffers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(bestOffers[position])
    }

    fun addItem(list: ArrayList<BestOffer>?) {
        bestOffers.clear()
        list?.let {
            bestOffers.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var bestOffers: BestOffer

        fun bindData(item: BestOffer) {
            this.bestOffers = item
            Glide.with(itemView.context)
                .load(itemView.context.resources.getDrawable(R.drawable.image_placeholder))
                .into(itemView.img_best_offer)
        }
    }
}
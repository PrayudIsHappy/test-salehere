package com.project.shimi.testsalehere.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.home.model.SuggestForYou
import kotlinx.android.synthetic.main.adapter_suggest_for_you.view.*

class SuggestForYouAdapter : RecyclerView.Adapter<SuggestForYouAdapter.ViewHolder>() {

    private val suggestForYous = ArrayList<SuggestForYou>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_suggest_for_you,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = suggestForYous.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(suggestForYous[position])
    }

    fun addItem(list: ArrayList<SuggestForYou>?) {
        suggestForYous.clear()
        list?.let {
            suggestForYous.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var suggestForYous: SuggestForYou

        fun bindData(item: SuggestForYou) {
            this.suggestForYous = item
            Glide.with(itemView.context)
                .load(itemView.context.resources.getDrawable(R.drawable.image_placeholder))
                .into(itemView.img_suggest_for_you)
        }
    }
}
package com.project.shimi.testsalehere.ui.achievement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.achievement.model.Achievement
import kotlinx.android.synthetic.main.adapter_achievement.view.*

class AchievementAdapter : RecyclerView.Adapter<AchievementAdapter.ViewHolder>() {

    private val achievements = ArrayList<Achievement>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_achievement,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = achievements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(achievements[position])
    }

    fun addItem(list: ArrayList<Achievement>?) {
        achievements.clear()
        list?.let {
            achievements.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var achievements: Achievement

        fun bindData(item: Achievement) {
            this.achievements = item
            Glide.with(itemView.context)
                .load(itemView.context.resources.getDrawable(R.drawable.ic_achievement_default_24dp))
                .into(itemView.img_achievement)
            itemView.tv_achievement_name.text = item.name
        }
    }
}
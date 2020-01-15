package com.project.shimi.testsalehere.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.home.model.Goal
import kotlinx.android.synthetic.main.adapter_goal.view.*

class GoalAdapter : RecyclerView.Adapter<GoalAdapter.ViewHolder>() {

    private val goals = ArrayList<Goal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_goal,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = goals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(goals[position])
    }

    fun addItem(list: ArrayList<Goal>?) {
        goals.clear()
        list?.let {
            goals.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var goals: Goal

        fun bindData(item: Goal) {
            this.goals = item
            itemView.root.apply {
                when (item.color) {
                    1 -> strokeColor = itemView.context.resources.getColor(R.color.colorAccent)
                    2 -> strokeColor = itemView.context.resources.getColor(R.color.colorGreen)
                }
            }
            itemView.tv_unknown1.text = item.unknown1
            itemView.tv_unknown2.text = item.unknown2
            itemView.tv_unknown3.text = item.unknown3
            itemView.tv_unknown4.apply {
                text = item.unknown4
                when (item.color) {
                    1 -> setTextColor(itemView.context.resources.getColor(R.color.colorAccent))
                    2 -> setTextColor(itemView.context.resources.getColor(R.color.colorGreen))
                }
            }
            itemView.tv_unknown5.text = item.unknown5
        }
    }
}
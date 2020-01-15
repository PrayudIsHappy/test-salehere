package com.project.shimi.testsalehere.ui.newgoal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.newgoal.model.NewGoalAction
import kotlinx.android.synthetic.main.adapter_new_goal_action.view.*

class NewGoalActionAdapter : RecyclerView.Adapter<NewGoalActionAdapter.ViewHolder>() {

    private val newGoalActions = ArrayList<NewGoalAction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_new_goal_action,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = newGoalActions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(newGoalActions[position])
    }

    fun addItem(list: ArrayList<NewGoalAction>?) {
        newGoalActions.clear()
        list?.let {
            newGoalActions.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var newGoalActions: NewGoalAction

        fun bindData(item: NewGoalAction) {
            this.newGoalActions = item
            Glide.with(itemView.context)
                .load(itemView.context.resources.getDrawable(R.drawable.image_placeholder))
                .into(itemView.img_new_goal_action)
            itemView.tv_new_goal_action_name.text = item.name
        }
    }
}
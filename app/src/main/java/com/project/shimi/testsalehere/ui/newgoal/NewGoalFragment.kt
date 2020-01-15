package com.project.shimi.testsalehere.ui.newgoal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.newgoal.adapter.NewGoalActionAdapter
import kotlinx.android.synthetic.main.fragment_new_goal.*

class NewGoalFragment : Fragment() {

    private lateinit var newGoalViewModel: NewGoalViewModel
    private val newGoalActionAdapter = NewGoalActionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newGoalViewModel =
            ViewModelProviders.of(this).get(NewGoalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_new_goal, container, false)
        newGoalViewModel.newGoalActions.observe(this, Observer {
            newGoalActionAdapter.addItem(it)
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_new_goal.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 3)
            adapter = newGoalActionAdapter
        }
    }
}
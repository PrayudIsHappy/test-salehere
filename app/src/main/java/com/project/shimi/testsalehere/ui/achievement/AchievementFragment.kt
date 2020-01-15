package com.project.shimi.testsalehere.ui.achievement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.achievement.adapter.AchievementAdapter
import kotlinx.android.synthetic.main.fragment_achievement.*

class AchievementFragment : Fragment() {

    private lateinit var achievementViewModel: AchievementViewModel
    private val achievementAdapter = AchievementAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        achievementViewModel =
            ViewModelProviders.of(this).get(AchievementViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_achievement, container, false)
        achievementViewModel.achievements.observe(this, Observer {
            achievementAdapter.addItem(it)
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_achievement.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 3)
            adapter = achievementAdapter
        }
    }
}
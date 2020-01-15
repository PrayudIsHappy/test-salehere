package com.project.shimi.testsalehere.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.shimi.testsalehere.R
import com.project.shimi.testsalehere.ui.home.adapter.BestOfferAdapter
import com.project.shimi.testsalehere.ui.home.adapter.GoalAdapter
import com.project.shimi.testsalehere.ui.home.adapter.SuggestForYouAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val goalAdapter = GoalAdapter()
    private val bestOfferAdapter = BestOfferAdapter()
    private val suggestForYouAdapter = SuggestForYouAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.goals.observe(this, Observer {
            goalAdapter.addItem(it)
        })
        homeViewModel.bestOffer.observe(this, Observer {
            bestOfferAdapter.addItem(it)
        })
        homeViewModel.suggestForYou.observe(this, Observer {
            suggestForYouAdapter.addItem(it)
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_goal.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = goalAdapter
        }

        rv_best_offer.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bestOfferAdapter
        }

        rv_suggest_for_you.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = suggestForYouAdapter
        }

        btn_new_goal.setOnClickListener { buttonView ->
            buttonView
                .findNavController()
                .navigate(R.id.actionHomeFragmentToNewGoalFragment)
        }
    }
}
package com.project.shimi.testsalehere.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.shimi.testsalehere.TestSalehereApp.Companion.applicationContext
import com.project.shimi.testsalehere.ui.home.model.BestOffer
import com.project.shimi.testsalehere.ui.home.model.Goal
import com.project.shimi.testsalehere.ui.home.model.SuggestForYou

class HomeViewModel : ViewModel() {

    private val _goals = MutableLiveData<ArrayList<Goal>>().apply {
        value = getGoalDataFromJson()
    }
    private val _bestOffer = MutableLiveData<ArrayList<BestOffer>>().apply {
        value = getBestOfferDataFromJson()
    }
    private val _suggestForYou = MutableLiveData<ArrayList<SuggestForYou>>().apply {
        value = getSuggestForYouDataFromJson()
    }

    val goals: LiveData<ArrayList<Goal>> = _goals
    val bestOffer: LiveData<ArrayList<BestOffer>> = _bestOffer
    val suggestForYou: LiveData<ArrayList<SuggestForYou>> = _suggestForYou

    private fun getGoalDataFromJson(): ArrayList<Goal> {
        var gson: ArrayList<Goal>
        applicationContext().let {
            val inputStream = it.assets.open("mock_goal.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val listType = object : TypeToken<ArrayList<Goal>>() {}.type
            gson = Gson().fromJson<ArrayList<Goal>>(json, listType)
        }
        return gson
    }

    private fun getBestOfferDataFromJson(): ArrayList<BestOffer> {
        var gson: ArrayList<BestOffer>
        applicationContext().let {
            val inputStream = it.assets.open("mock_best_offer.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val listType = object : TypeToken<ArrayList<BestOffer>>() {}.type
            gson = Gson().fromJson<ArrayList<BestOffer>>(json, listType)
        }
        return gson
    }

    private fun getSuggestForYouDataFromJson(): ArrayList<SuggestForYou> {
        var gson: ArrayList<SuggestForYou>
        applicationContext().let {
            val inputStream = it.assets.open("mock_suggest_for_you.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val listType = object : TypeToken<ArrayList<SuggestForYou>>() {}.type
            gson = Gson().fromJson<ArrayList<SuggestForYou>>(json, listType)
        }
        return gson
    }
}
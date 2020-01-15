package com.project.shimi.testsalehere.ui.newgoal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.shimi.testsalehere.TestSalehereApp
import com.project.shimi.testsalehere.ui.newgoal.model.NewGoalAction

class NewGoalViewModel : ViewModel() {

    private val _newGoalActions = MutableLiveData<ArrayList<NewGoalAction>>().apply {
        value = getNewGoalActionDataFromJson()
    }
    val newGoalActions: LiveData<ArrayList<NewGoalAction>> = _newGoalActions

    private fun getNewGoalActionDataFromJson(): ArrayList<NewGoalAction> {
        var gson: ArrayList<NewGoalAction>
        TestSalehereApp.applicationContext().let {
            val inputStream = it.assets.open("mock_new_goal_action.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val listType = object : TypeToken<ArrayList<NewGoalAction>>() {}.type
            gson = Gson().fromJson<ArrayList<NewGoalAction>>(json, listType)
        }
        return gson
    }
}
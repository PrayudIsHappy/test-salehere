package com.project.shimi.testsalehere.ui.achievement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.shimi.testsalehere.TestSalehereApp
import com.project.shimi.testsalehere.ui.achievement.model.Achievement

class AchievementViewModel : ViewModel() {

    private val _achievements = MutableLiveData<ArrayList<Achievement>>().apply {
        value = getAchievementDataFromJson()
    }

    val achievements: LiveData<ArrayList<Achievement>> = _achievements

    private fun getAchievementDataFromJson(): ArrayList<Achievement> {
        var gson: ArrayList<Achievement>
        TestSalehereApp.applicationContext().let {
            val inputStream = it.assets.open("mock_achievement.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, charset("UTF-8"))
            val listType = object : TypeToken<ArrayList<Achievement>>() {}.type
            gson = Gson().fromJson<ArrayList<Achievement>>(json, listType)
        }
        return gson
    }
}
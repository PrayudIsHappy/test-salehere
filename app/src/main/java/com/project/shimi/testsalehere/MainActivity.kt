package com.project.shimi.testsalehere

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import org.json.JSONException
import org.json.JSONObject
import com.github.nkzawa.emitter.Emitter

class MainActivity : AppCompatActivity() {

    private val navView: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.nav_view)
    }

    private val badgeDrawable: BadgeDrawable by lazy {
        navView.getOrCreateBadge(R.id.navigation_account)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as TestSalehereApp).getSocketInstance().apply {
            on("new-notification", onNewNotification)
        }

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }

    private val onNewNotification = Emitter.Listener { args ->
        this.runOnUiThread(Runnable {
            val data = args[0] as JSONObject
            try {
                Toast.makeText(this, data.getString("message"), Toast.LENGTH_SHORT).show()
                updateBadge(data.length())
            } catch (e: JSONException) {
                return@Runnable
            }
        })
    }

    private fun updateBadge(count: Int) {
        (application as TestSalehereApp).setBadgeCount(count)
        badgeDrawable.apply {
            number = (application as TestSalehereApp).getBadgeCount()
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        (application as TestSalehereApp).getSocketInstance().apply {
//            disconnect()
//        }
//    }
}

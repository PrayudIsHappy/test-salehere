package com.project.shimi.testsalehere

import android.app.Application
import android.content.Context
import android.util.Log
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket

class TestSalehereApp : Application() {

    init {
        instance = this
    }

    companion object {
        private const val url = "https://px-socket-api.herokuapp.com/"

        private var instance: TestSalehereApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    private lateinit var socket: Socket
    private var badgeCount: Int = 0

    override fun onCreate() {
        super.onCreate()
        socket = IO.socket(url)
        socket.let {
            it.connect()
                .on(Socket.EVENT_CONNECT) {
                    Log.d("Socket", "Connected!!!!")
                }.on(Socket.EVENT_DISCONNECT) {
                    Log.d("Socket", "Disconnected!!!!")
                }
        }
    }

    fun getSocketInstance() = socket

    fun setBadgeCount(count: Int) {
        this.badgeCount += count
    }

    fun getBadgeCount() = badgeCount
}
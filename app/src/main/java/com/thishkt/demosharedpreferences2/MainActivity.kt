package com.thishkt.demosharedpreferences2

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shardPref = getSharedPreferences("mydata", Context.MODE_PRIVATE)
        val login_state = shardPref.getBoolean("login_state", false)
        updateLoginState(login_state)

        btn_login.setOnClickListener {
            shardPref.edit().putBoolean("login_state",true).apply()
            updateLoginState(true)
        }

        btn_logout.setOnClickListener {
            shardPref.edit().putBoolean("login_state",false).apply()
            updateLoginState(false)
        }
    }

    private fun updateLoginState(login_state: Boolean) {
        if (login_state) {
            ll_login.visibility = View.GONE
            ll_welcome.visibility = View.VISIBLE
        } else {
            ll_login.visibility = View.VISIBLE
            ll_welcome.visibility = View.GONE
        }
    }
}

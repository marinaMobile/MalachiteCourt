package com.disney.emojimatch_go.black

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.Log
import androidx.activity.viewModels
import com.appsflyer.AppsFlyerLib
import com.disney.emojimatch_go.R
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val prefs = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        if (prefs.getBoolean("activity_exec", false)) {
            Intent(this, Filter::class.java).also { startActivity(it) }
            finish()
        } else {
            val exec = prefs.edit()
            exec.putBoolean("activity_exec", true)
            exec.apply()
        }

        viewModel.deePP(this)
        Handler().postDelayed({
            toTestGrounds()
        }, 2000)

    }


    private fun toTestGrounds() {
        Intent(this, Filter::class.java)
            .also { startActivity(it) }
        finish()
    }

}


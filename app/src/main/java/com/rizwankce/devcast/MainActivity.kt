package com.rizwankce.devcast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val networking = NetworkingService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPodcasts()
    }

    private fun getPodcasts() {
        networking.fetchPoscasts().observe(this, Observer { podcastList ->
            podcastList.forEach { println(it)}
        })
    }
}
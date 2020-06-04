package com.rizwankce.devcast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val networking = NetworkingService()
    private val podcastAdapter = PodcastAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = podcastAdapter

        getPodcasts()
    }

    private fun getPodcasts() {
        networking.fetchPoscasts().observe(this, Observer { podcastList ->
            podcastList.forEach { println(it)}
            podcastAdapter.update(podcastList)
        })
    }
}
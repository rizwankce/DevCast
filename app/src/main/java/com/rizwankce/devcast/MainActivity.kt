package com.rizwankce.devcast

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val networking = NetworkingService()
    private val podcastAdapter = PodcastAdapter()
    private lateinit var progressBar: ProgressBar

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = podcastAdapter

        progressBar = findViewById(R.id.progressBar)
        hideProgressBar()

        getPodcasts()
    }

    private fun getPodcasts() {
        showProgressBar()
        networking.fetchPoscasts().observe(this, Observer { podcastList ->
            podcastList.forEach { println(it)}
            hideProgressBar()
            podcastAdapter.update(podcastList)
        })
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
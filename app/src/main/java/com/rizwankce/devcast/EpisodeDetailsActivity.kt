package com.rizwankce.devcast

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class EpisodeDetailsActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_details)

        val episode = intent.getSerializableExtra(PodcastCard.episodeKey) as? PodcastList
        episode?.let {
            supportActionBar?.title = "DevCast - " + it.podcast.title
            loadWebView("https://dev.to/"+it.path)
        }
    }

    private fun loadWebView(urlString: String) {
        webView = findViewById(R.id.webView)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl(urlString)
    }
}
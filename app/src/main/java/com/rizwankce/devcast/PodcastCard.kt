package com.rizwankce.devcast

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_podcast_card.view.*

class PodcastCard(episodeView: View, var episode: PodcastList? = null): RecyclerView.ViewHolder(episodeView) {
    val episodeTitle: TextView = episodeView.episodeTitleTextView
    val podcastTitle: TextView = episodeView.podcastTitleTextView

    init {
        episodeView.setOnClickListener {
            episode?.let {
                println("selected podcast title"+ it.title)
                val intent = Intent(episodeView.context, EpisodeDetailsActivity::class.java)
                intent.putExtra(episodeKey, it)
                episodeView.context.startActivity(intent)
            }
        }
    }

    companion object {
        const val episodeKey = "episodeKey"
    }
}
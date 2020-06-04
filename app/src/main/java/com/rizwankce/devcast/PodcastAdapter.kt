package com.rizwankce.devcast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PodcastAdapter: RecyclerView.Adapter<PodcastCard>() {

    var episodes = emptyList<PodcastList>()

    override fun getItemCount(): Int = episodes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastCard {
        val episodeView = LayoutInflater.from(parent.context).inflate(R.layout.activity_podcast_card, parent, false)
        return PodcastCard(episodeView)
    }

    override fun onBindViewHolder(holder: PodcastCard, position: Int) {
        val episode = episodes[position]
        holder.episodeTitle.text = episode.title
        holder.podcastTitle.text = episode.podcast.title
        holder.episode = episode
    }

    fun update(episodes: List<PodcastList>) {
        this.episodes = episodes
        notifyDataSetChanged()
    }

}
package com.rizwankce.devcast

import retrofit2.http.GET

interface ApiService {
    // http GET 'https://dev.to/api/podcast_episodes'

    @GET(value = "podcast_episodes")
    suspend fun fetchPodcasts(): List<PodcastList>
}
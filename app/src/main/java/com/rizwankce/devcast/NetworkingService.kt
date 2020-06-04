package com.rizwankce.devcast

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkingService {

    val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://dev.to/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun fetchPoscasts(): LiveData<List<PodcastList>> {
        return object: LiveData<List<PodcastList>>() {
            override fun onActive() {
                super.onActive()

                CoroutineScope(Dispatchers.IO).launch {
                    val response = apiService.fetchPodcasts()

                    withContext(Dispatchers.Main) {
                        value = response
                    }
                }
            }
        }
    }
}
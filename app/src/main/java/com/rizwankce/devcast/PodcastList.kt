package com.rizwankce.devcast

import com.google.gson.annotations.SerializedName

//{
//    "type_of": "podcast_episodes",
//    "class_name": "PodcastEpisode",
//    "id": 14756,
//    "path": "/ladybugpodcast/outliers",
//    "title": "Outliers",
//    "image_url": "https://dev-to-uploads.s3.amazonaws.com/uploads/podcast/image/96/00b3c6d0-8231-4a5c-9163-18ced3eea07c.png",
//    "podcast": {
//    "title": "Ladybug Podcast",
//    "slug": "ladybugpodcast",
//    "image_url": "https://dev-to-uploads.s3.amazonaws.com/uploads/podcast/image/96/00b3c6d0-8231-4a5c-9163-18ced3eea07c.png"
//}
//}


data class PodcastList(
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "path")
    val path: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "image_url")
    val imageUrl: String,
    @SerializedName(value = "podcast")
    val podcast: PodCast
) {
}

data class PodCast(
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "slug")
    val slug: String,
    @SerializedName(value = "image_url")
    val imageUrl: String
) {

}
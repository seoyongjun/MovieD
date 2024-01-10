package com.movie.movied.data.api.common

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("vote_count") val vcount: Long,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("popularity") val prating: Float
)

data class GetMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MovieData>,
    @SerializedName("total_pages") val pages: Int,
    @SerializedName("total_results") val results: Int
)

data class MovieDetail(
    val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String,
)

data class MovieVideos(
    val results: List<Video>,
)

data class Video(
    val key: String?,
)

data class MovieCredits(
    val cast: List<Cast>,
)

data class Cast(
    val id: Int,
    val name: String,
    val character: String,
)
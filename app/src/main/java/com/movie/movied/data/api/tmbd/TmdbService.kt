package com.movie.movied.data.api.tmbd

import com.movie.movied.data.api.common.GetMovieResponse
import com.movie.movied.data.api.common.MovieCredits
import com.movie.movied.data.api.common.MovieDetail
import com.movie.movied.data.api.common.MovieVideos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "dd48a3f4321bdecde9e26a97f0add403"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val BACK_BASE_URL = "https://image.tmdb.org/t/p/w780"
const val YOUTUBE_URL = "https://www.youtube.com/watch?v="
const val YOUTUBE_IMAGE_URL = "https://img.youtube.com/vi/"


interface TmdbService {

    @GET("search/movie")
    fun searchMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page : Int,
        @Query("query") query: String,
        @Query("language") language : String = "ko-KR"
    ): Call<GetMovieResponse>

    @GET("movie/popular")
    fun getMoviePopularList(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page : Int,
        @Query("language") language : String = "ko-KR"
    ): Call<GetMovieResponse>

    @GET("movie/top_rated")
    fun getMovieTopRatedList(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page : Int,
        @Query("language") language : String = "ko-KR"
    ): Call<GetMovieResponse>

    @GET("discover/movie")
    fun getDiscoverMoviesList(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("sort_by") sortBy: String = "release_date.desc",
        @Query("page") page : Int,
        @Query("language") language : String = "ko-KR"
    ): Call<GetMovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language : String = "ko-KR"
    ): Call<MovieDetail>

    @GET("movie/{movie_id}/videos")
    fun getMovieVideos(
        @Path("movie_id") Id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language : String = "ko-KR"
    ): Call<MovieVideos>

    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(
        @Path("movie_id") Id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language : String = "ko-KR"
    ): Call<MovieCredits>
}
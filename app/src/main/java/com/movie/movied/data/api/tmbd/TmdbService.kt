package com.movie.movied.data.api.tmbd

import com.movie.movied.data.api.common.GetMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "dd48a3f4321bdecde9e26a97f0add403"
const val BASE_URL = "https://api.themoviedb.org/3/"

interface TmdbService {
    @GET("movie/popular")
    fun getMovieList(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page : Int,
        @Query("language") language : String = "ko,ko-KO"
    ): Call<GetMovieResponse>
}
package com.movie.movied.data.di

import android.util.Log
import com.movie.movied.data.api.common.GetMovieResponse
import com.movie.movied.data.api.tmbd.BASE_URL
import com.movie.movied.data.api.tmbd.TmdbService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TMDBRepository {
    private var service: TmdbService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(TmdbService::class.java)
    }

    fun getMovieList(page: Int = 2) {
        service.getMovieList(page = page)
            .enqueue(object : Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("Repository", "Movies: ${responseBody.movies}")
                        } else {
                            Log.d("Repository", "Failed to get response")
                        }
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    Log.e("Repository", "onFailure", t)
                }
            })
    }
}
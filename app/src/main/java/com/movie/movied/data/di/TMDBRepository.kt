package com.movie.movied.data.di

import com.movie.movied.data.api.common.GetMovieResponse
import com.movie.movied.data.api.common.MovieCredits
import com.movie.movied.data.api.common.MovieData
import com.movie.movied.data.api.common.MovieDetail
import com.movie.movied.data.api.common.MovieVideos
import com.movie.movied.data.api.tmbd.BASE_URL
import com.movie.movied.data.api.tmbd.TmdbService
import com.movie.movied.utils.utils.debug
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

    fun getSearchMovieList(page: Int = 1, query: String, onSuccess: (movies: List<MovieData>) -> Unit, onError: () -> Unit ) {
        service.searchMovies(page = page, query = query).enqueue(object : Callback<GetMovieResponse> {
            override fun onResponse(
                call: Call<GetMovieResponse>,
                response: Response<GetMovieResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        onSuccess(responseBody.movies)
                        debug("Repository ${responseBody.pages}")
                    } else {
                        onError()
                    }
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                onError()
            }
        })
    }

    fun getMoviePopularList(page: Int = 1, onSuccess: (movies: List<MovieData>) -> Unit, onError: () -> Unit) {
        service.getMoviePopularList(page = page)
            .enqueue(object : Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess(responseBody.movies)
                            debug("Repository ${responseBody.pages}")
                        } else {
                            onError()
                        }
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    onError()
                }
            })
    }

    fun getMovieTopRatedList(page: Int = 1, onSuccess: (movies: List<MovieData>) -> Unit, onError: () -> Unit) {
        service.getMovieTopRatedList(page = page).enqueue(object  : Callback<GetMovieResponse> {
            override fun onResponse(
                call: Call<GetMovieResponse>,
                response: Response<GetMovieResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        onSuccess(responseBody.movies)
                    } else {
                        onError()
                    }
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                onError()
            }

        })
    }

    fun getDiscoverMoviesList(page: Int = 1, onSuccess: (movies: List<MovieData>) -> Unit, onError: () -> Unit) {
        service.getDiscoverMoviesList(page = page).enqueue(object  : Callback<GetMovieResponse> {
            override fun onResponse(
                call: Call<GetMovieResponse>,
                response: Response<GetMovieResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        onSuccess(responseBody.movies)
                    } else {
                        onError()
                    }
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                onError()
            }

        })
    }

    fun getMovieDetail(id: Int, onSuccess: (movies: MovieDetail) -> Unit, onError: () -> Unit) {
        service.getMovieDetail(id= id).enqueue(object : Callback<MovieDetail>{
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        onSuccess(responseBody)
                    } else {
                        onError()
                    }
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                onError()
            }

        })
    }

    fun getMovieVideos(id: Int, onSuccess: (movies: MovieVideos) -> Unit, onError: () -> Unit) {
        service.getMovieVideos(id).enqueue(object : Callback<MovieVideos>{
            override fun onResponse(call: Call<MovieVideos>, response: Response<MovieVideos>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        onSuccess(responseBody)
                    } else {
                        onError()
                    }
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<MovieVideos>, t: Throwable) {
                onError()
            }

        })
    }

    fun getMovieCredits(id: Int, onSuccess: (movies: MovieCredits) -> Unit, onError: () -> Unit) {
        service.getMovieCredits(id).enqueue(object : Callback<MovieCredits>{
            override fun onResponse(call: Call<MovieCredits>, response: Response<MovieCredits>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        onSuccess(responseBody)
                    } else {
                        onError()
                    }
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<MovieCredits>, t: Throwable) {
                onError()
            }

        })
    }
}
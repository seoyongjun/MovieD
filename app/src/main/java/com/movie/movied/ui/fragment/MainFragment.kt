package com.movie.movied.ui.fragment

import android.os.Bundle
import android.view.View
import com.movie.movied.R
import com.movie.movied.data.di.TMDBRepository
import com.movie.movied.databinding.FragmentMainBinding
import com.movie.movied.ui.base.ui.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBind()
        setUpObserver()
        setUpData()
    }

    private fun setUpBind() {
        TMDBRepository.getMovieList()
    }

    private fun setUpObserver() {

    }

    private fun setUpData() {

    }
}
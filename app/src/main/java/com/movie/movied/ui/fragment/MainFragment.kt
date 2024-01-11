package com.movie.movied.ui.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.movie.movied.R
import com.movie.movied.data.api.common.MovieData
import com.movie.movied.data.di.TMDBRepository
import com.movie.movied.databinding.FragmentMainBinding
import com.movie.movied.ui.activity.recyclerview.MovieListAdapter
import com.movie.movied.ui.base.ui.BaseFragment
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder
import com.movie.movied.utils.utils.debug

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val onMovieListRecyclerViewItemClickListener =
        object : BaseRecyclerViewHolder.ItemClickListener<MovieData> {
            override fun onClick(item: MovieData, position: Int) {
                debug("Repository ${item.title}, $position")
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailMovieFragment(item.id))
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBind(view.context)
        setUpObserver()
        setUpData()
    }

    private fun setUpBind(context: Context) {
        setUpFilterButton()
        setUpRecyclerView(context)
        binding.filterButton.check(R.id.rbPopular)
        binding.search.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TMDBRepository.getSearchMovieList(query = p0.toString(), onSuccess =  {
                    (binding.rvMovieList.adapter as MovieListAdapter).set(it)
                }, onError =  {
                    debug("error")
                })
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun setUpObserver() {

    }

    private fun setUpData() {

    }

    private fun setUpFilterButton() {
        binding.rbPopular.setOnClickListener{
            binding.progress.isVisible = true
            TMDBRepository.getMoviePopularList(1,
                onSuccess = {
                    (binding.rvMovieList.adapter as MovieListAdapter).set(it)
                    binding.progress.isVisible = false
                }, onError = {
                    debug("error")
                })
        }

        binding.rbRating.setOnClickListener {
            binding.progress.isVisible = true
            TMDBRepository.getMovieTopRatedList(1,
                onSuccess = {
                    (binding.rvMovieList.adapter as MovieListAdapter).set(it)
                    binding.progress.isVisible = false
                }, onError = {
                    debug("error")
                })
        }

        binding.rbNewest.setOnClickListener {
            binding.progress.isVisible = true
            TMDBRepository.getDiscoverMoviesList(1, onSuccess = {
                (binding.rvMovieList.adapter as MovieListAdapter).set(it)
                binding.progress.isVisible = false
            }, onError = {
                debug("error")
            })
        }

        binding.rbFavorite.setOnClickListener {
            binding.progress.isVisible = true
            binding.progress.isVisible = false
        }
    }

    private fun setUpRecyclerView(context: Context) {
        binding.rvMovieList.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            TMDBRepository.getMoviePopularList(page = 1,
                onSuccess = {
                    binding.progress.isVisible = false
                    adapter = MovieListAdapter().apply {
                        set(it)
                        listener = onMovieListRecyclerViewItemClickListener
                    }
                }, onError = {
                })

        }
    }
}
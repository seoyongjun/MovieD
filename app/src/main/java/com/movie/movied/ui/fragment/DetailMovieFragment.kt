package com.movie.movied.ui.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.movie.movied.R
import com.movie.movied.data.api.common.Video
import com.movie.movied.data.api.tmbd.BACK_BASE_URL
import com.movie.movied.data.api.tmbd.IMAGE_BASE_URL
import com.movie.movied.data.api.tmbd.YOUTUBE_URL
import com.movie.movied.data.di.TMDBRepository
import com.movie.movied.databinding.FragmentDetailMovieBinding
import com.movie.movied.ui.activity.recyclerview.CastListAdapter
import com.movie.movied.ui.activity.recyclerview.VideoListAdapter
import com.movie.movied.ui.base.ui.BaseFragment
import com.movie.movied.utils.recyclerView.BaseRecyclerViewHolder
import com.movie.movied.utils.utils.debug

class DetailMovieFragment : BaseFragment<FragmentDetailMovieBinding>(R.layout.fragment_detail_movie) {

    private val args by navArgs<DetailMovieFragmentArgs>()

    private val onVideoListRecyclerViewItemClickListener =
        object : BaseRecyclerViewHolder.ItemClickListener<Video> {
            override fun onClick(item: Video, position: Int) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_URL+item.key))
                startActivity(intent)
            }
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBind(view.context)
        setUpObserver()
        setUpData()
    }

    private fun setUpBind(context: Context) {

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        TMDBRepository.getMovieDetail(args.id.toInt(), {
            Glide.with(this)
                .load(IMAGE_BASE_URL + it.poster_path)
                .transform(CenterCrop())
                .into(binding.poster)

            Glide.with(this)
                .load(BACK_BASE_URL + it.backdrop_path)
                .transform(CenterCrop())
                .into(binding.backImage)

            binding.title.text = it.title
            binding.overview.text = it.overview
        }, {
            debug("error")
        })
        setUpRecyclerView(context)
    }

    private fun setUpObserver() {

    }

    private fun setUpData() {

    }

    private fun setUpRecyclerView(context: Context) {
        binding.rvCastList.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            TMDBRepository.getMovieCredits(args.id.toInt(), {
                adapter = CastListAdapter().apply {
                    set(it.cast)
                    binding.progress.isVisible = false
                }
            }, {
                debug("error")
                binding.progress.isVisible = false
            })
        }

        binding.rvVideoList.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            TMDBRepository.getMovieVideos(args.id.toInt(), {
                adapter = VideoListAdapter().apply {
                    set(it.results)
                    listener = onVideoListRecyclerViewItemClickListener
                    binding.progress.isVisible = false
                }
            }, {
                debug("error")
                binding.progress.isVisible = false
            })
        }
    }
}
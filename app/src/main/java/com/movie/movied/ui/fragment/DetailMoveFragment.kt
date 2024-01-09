package com.movie.movied.ui.fragment

import android.os.Bundle
import android.view.View
import com.movie.movied.R
import com.movie.movied.databinding.FragmentDetailMoveBinding
import com.movie.movied.ui.base.ui.BaseFragment

class DetailMoveFragment : BaseFragment<FragmentDetailMoveBinding>(R.layout.fragment_detail_move) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBind()
        setUpObserver()
        setUpData()
    }

    private fun setUpBind() {

    }

    private fun setUpObserver() {

    }

    private fun setUpData() {

    }
}
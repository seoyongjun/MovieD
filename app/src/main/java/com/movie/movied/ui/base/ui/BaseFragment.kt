package com.movie.movied.ui.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment <DB: ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    Fragment() {
    protected lateinit var binding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.setLifecycleOwner(viewLifecycleOwner)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
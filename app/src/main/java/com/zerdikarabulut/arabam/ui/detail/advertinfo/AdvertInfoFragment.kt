package com.zerdikarabulut.arabam.ui.detail.advertinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zerdikarabulut.arabam.data.mock.Mock
import com.zerdikarabulut.arabam.databinding.FragmentAdvertInfoBinding
import com.zerdikarabulut.arabam.ui.adapter.ViewPagerAdvertInfoAdapter


class AdvertInfoFragment : Fragment() {
    private lateinit var binding: FragmentAdvertInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdvertInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdvertInfoAdapter(Mock.viewPagerAdvertInformations)
        binding.rvAdvertInfo.adapter = adapter
    }
}
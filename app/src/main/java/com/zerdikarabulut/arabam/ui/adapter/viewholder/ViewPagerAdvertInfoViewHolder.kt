package com.zerdikarabulut.arabam.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.zerdikarabulut.arabam.data.model.ViewPagerAdvertInfo
import com.zerdikarabulut.arabam.databinding.ItemAdvertInfoBinding
import com.zerdikarabulut.arabam.ui.detail.advertinfo.AdvertInfoViewState

class ViewPagerAdvertInfoViewHolder(val binding: ItemAdvertInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(viewPagerAdvertInfo: ViewPagerAdvertInfo, isColor: Boolean) {
        binding.viewItemState = AdvertInfoViewState(viewPagerAdvertInfo)
        binding.carAdvertInfo = viewPagerAdvertInfo
        binding.isColor = isColor
    }
}
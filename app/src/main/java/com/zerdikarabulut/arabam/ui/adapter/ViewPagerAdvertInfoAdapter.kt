package com.zerdikarabulut.arabam.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zerdikarabulut.arabam.R
import com.zerdikarabulut.arabam.data.model.ViewPagerAdvertInfo
import com.zerdikarabulut.arabam.databinding.ItemAdvertInfoBinding
import com.zerdikarabulut.arabam.ui.adapter.viewholder.ViewPagerAdvertInfoViewHolder

class ViewPagerAdvertInfoAdapter(private var viewPagerAdvertInfo: ArrayList<ViewPagerAdvertInfo>) :
    RecyclerView.Adapter<ViewPagerAdvertInfoViewHolder>() {
    private var isColor = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdvertInfoViewHolder {
        val binding: ItemAdvertInfoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_advert_info,
            parent,
            false
        )
        return ViewPagerAdvertInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdvertInfoViewHolder, position: Int) {
        holder.bind(viewPagerAdvertInfo[position], isColor)
        isColor = !isColor
    }

    override fun getItemCount(): Int = viewPagerAdvertInfo.size
}
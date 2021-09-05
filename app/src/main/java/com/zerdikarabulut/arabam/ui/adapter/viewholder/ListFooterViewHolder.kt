package com.zerdikarabulut.arabam.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zerdikarabulut.arabam.R
import com.zerdikarabulut.arabam.databinding.ItemListFooterBinding
import com.zerdikarabulut.arabam.util.State

class ListFooterViewHolder(val binding: ItemListFooterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(state: State?, retry: () -> Unit) {
        binding.stateProgress = state == State.LOADING
        binding.stateError = state == State.ERROR
        binding.tvError.setOnClickListener { retry() }
    }

    companion object {
        fun create(parent: ViewGroup): ListFooterViewHolder {
            val binding: ItemListFooterBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_list_footer,
                parent,
                false
            )
            return ListFooterViewHolder(binding)
        }
    }
}
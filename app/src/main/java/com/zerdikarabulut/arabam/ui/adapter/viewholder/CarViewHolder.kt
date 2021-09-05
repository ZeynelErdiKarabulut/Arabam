package com.zerdikarabulut.arabam.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zerdikarabulut.arabam.R
import com.zerdikarabulut.arabam.data.local.entity.SelectedCarEntity
import com.zerdikarabulut.arabam.data.mock.Mock
import com.zerdikarabulut.arabam.data.model.CarResponse
import com.zerdikarabulut.arabam.databinding.ItemCarBinding
import com.zerdikarabulut.arabam.ui.home.viewstate.HomeItemViewState

class CarViewHolder(val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        car: CarResponse?,
        carItemClick: (Long) -> Unit,
    ) {
        car?.let { carItem ->
            Mock.selectedCars?.add(SelectedCarEntity(Mock.selectedCarForBackId))
            binding.car = HomeItemViewState(carItem, Mock.selectedCars)
            binding.root.setOnClickListener {
                carItem.id.let { it1 -> carItemClick.invoke(it1) }
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): CarViewHolder {
            val binding: ItemCarBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_car,
                parent,
                false
            )
            return CarViewHolder(binding)
        }
    }
}
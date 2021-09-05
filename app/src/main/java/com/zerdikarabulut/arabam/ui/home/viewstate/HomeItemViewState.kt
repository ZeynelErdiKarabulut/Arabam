package com.zerdikarabulut.arabam.ui.home.viewstate

import android.util.Log
import com.zerdikarabulut.arabam.data.local.entity.SelectedCarEntity
import com.zerdikarabulut.arabam.data.model.CarResponse
import com.zerdikarabulut.arabam.util.toConvert

data class HomeItemViewState(
    private val car: CarResponse,
    private val selectedCars: List<SelectedCarEntity>?
) {

    fun selectedCarsFind(): Boolean? {
        val find = selectedCars?.find { it.selected_car_id == car.id.toInt() }

        selectedCars?.forEach {
            Log.e("JRDevs", it.selected_car_id.toString())
        }

        find?.let {
            return true
        }
        return false
    }

    fun photo() = car.photo ?: ""

    fun priceFormatted() = car.priceFormatted ?: ""

    fun categoryName() = car.category?.name ?: ""

    fun title() = car.title ?: ""

    fun location() = "${car.location?.cityName} / ${car.location?.townName}"

    fun dateFormatted() = car.dateFormatted ?: ""

    fun properties(): String {
        return car.properties.toConvert()
    }
}
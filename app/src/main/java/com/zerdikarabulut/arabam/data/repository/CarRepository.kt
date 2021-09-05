package com.zerdikarabulut.arabam.data.repository

import com.zerdikarabulut.arabam.data.local.dao.CarDAO
import com.zerdikarabulut.arabam.data.local.dao.FavoriteDAO
import com.zerdikarabulut.arabam.data.local.dao.SelectedCarDAO
import com.zerdikarabulut.arabam.data.local.entity.FavoriteEntity
import com.zerdikarabulut.arabam.data.local.entity.SelectedCarEntity
import com.zerdikarabulut.arabam.data.network.APIService
import javax.inject.Inject

class CarRepository @Inject constructor(
    private val apiService: APIService,
    private val carDAO: CarDAO,
    private val selectedCarDAO: SelectedCarDAO,
    private val favoriteDAO: FavoriteDAO
) {
    fun getDetail(id: Long) = apiService.getDetail(id)

    fun addSelectCar(selectedCarEntity: SelectedCarEntity) =
        selectedCarDAO.addSelectCar(selectedCarEntity)

    suspend fun getAllSelectedCars() = selectedCarDAO.getAllSelectedCars()

    suspend fun getAllFavorite() = favoriteDAO.getAllFavorite()

    suspend fun insertFavorite(favoriteEntity: FavoriteEntity) = favoriteDAO.insert(favoriteEntity)

    suspend fun deleteFavorite(id: Long) = favoriteDAO.deleteById(id)
}
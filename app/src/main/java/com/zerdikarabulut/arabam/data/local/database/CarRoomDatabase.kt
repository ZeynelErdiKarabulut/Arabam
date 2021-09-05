package com.zerdikarabulut.arabam.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zerdikarabulut.arabam.data.local.dao.CarDAO
import com.zerdikarabulut.arabam.data.local.dao.FavoriteDAO
import com.zerdikarabulut.arabam.data.local.dao.SelectedCarDAO
import com.zerdikarabulut.arabam.data.local.entity.CarEntity
import com.zerdikarabulut.arabam.data.local.entity.FavoriteEntity
import com.zerdikarabulut.arabam.data.local.entity.SelectedCarEntity

@Database(
    entities = [CarEntity::class, SelectedCarEntity::class, FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CarRoomDatabase : RoomDatabase() {
    abstract fun carDAO(): CarDAO
    abstract fun selectedCarDAO(): SelectedCarDAO
    abstract fun favoriteDAO(): FavoriteDAO
}
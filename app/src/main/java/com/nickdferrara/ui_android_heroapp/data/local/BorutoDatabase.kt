package com.nickdferrara.ui_android_heroapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nickdferrara.ui_android_heroapp.data.local.dao.HeroDao
import com.nickdferrara.ui_android_heroapp.data.local.dao.HeroRemoteKeyDao
import com.nickdferrara.ui_android_heroapp.domain.models.Hero
import com.nickdferrara.ui_android_heroapp.domain.models.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}
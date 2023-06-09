package com.nickdferrara.ui_android_heroapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nickdferrara.ui_android_heroapp.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)

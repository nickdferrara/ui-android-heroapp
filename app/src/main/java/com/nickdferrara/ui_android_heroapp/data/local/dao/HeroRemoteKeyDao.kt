package com.nickdferrara.ui_android_heroapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nickdferrara.ui_android_heroapp.domain.models.HeroRemoteKeys

@Dao
interface HeroRemoteKeyDao {
    @Query("SELECT * FROM hero_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): HeroRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKeys>)

    @Query("DELETE FROM hero_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}
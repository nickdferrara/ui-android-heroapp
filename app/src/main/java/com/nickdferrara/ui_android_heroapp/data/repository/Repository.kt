package com.nickdferrara.ui_android_heroapp.data.repository

import androidx.paging.PagingData
import com.nickdferrara.ui_android_heroapp.domain.interfaces.IDataStore
import com.nickdferrara.ui_android_heroapp.domain.interfaces.IRemoteDataSource
import com.nickdferrara.ui_android_heroapp.domain.models.Hero
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: IRemoteDataSource,
    private val dataStore: IDataStore
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingStatue(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }
}
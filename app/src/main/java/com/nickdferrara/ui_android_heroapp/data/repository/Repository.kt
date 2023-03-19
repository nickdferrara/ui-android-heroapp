package com.nickdferrara.ui_android_heroapp.data.repository

import com.nickdferrara.ui_android_heroapp.domain.interfaces.IDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: IDataStore
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingStatue(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}
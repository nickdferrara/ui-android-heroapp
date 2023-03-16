package com.nickdferrara.ui_android_heroapp.domain.repository.interfaces

import kotlinx.coroutines.flow.Flow

interface IDataStore {
    suspend fun saveOnBoardingState(isCompleted: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}
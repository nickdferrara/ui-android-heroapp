package com.nickdferrara.ui_android_heroapp.domain.interfaces

import androidx.paging.PagingData
import com.nickdferrara.ui_android_heroapp.domain.models.Hero
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(): Flow<PagingData<Hero>>
}
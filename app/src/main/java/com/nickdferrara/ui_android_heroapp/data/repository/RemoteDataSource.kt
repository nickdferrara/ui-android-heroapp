package com.nickdferrara.ui_android_heroapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nickdferrara.ui_android_heroapp.data.local.BorutoDatabase
import com.nickdferrara.ui_android_heroapp.data.paging_source.HeroRemoteMediator
import com.nickdferrara.ui_android_heroapp.data.remote.IBorutoApi
import com.nickdferrara.ui_android_heroapp.domain.interfaces.IRemoteDataSource
import com.nickdferrara.ui_android_heroapp.domain.models.Hero
import com.nickdferrara.ui_android_heroapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSource (
    private val borutoApi: IBorutoApi,
    private val borutoDatabase: BorutoDatabase
    ): IRemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}
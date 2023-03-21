package com.nickdferrara.ui_android_heroapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.nickdferrara.ui_android_heroapp.data.repository.Repository
import com.nickdferrara.ui_android_heroapp.domain.models.Hero
import kotlinx.coroutines.flow.Flow


class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}
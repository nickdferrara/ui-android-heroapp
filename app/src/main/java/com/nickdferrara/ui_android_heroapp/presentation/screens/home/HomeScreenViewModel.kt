package com.nickdferrara.ui_android_heroapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.nickdferrara.ui_android_heroapp.domain.use_cases.UseCases
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(useCases: UseCases): ViewModel() {
    val getAllHeroes = useCases.getAllHeroesUseCase()
}
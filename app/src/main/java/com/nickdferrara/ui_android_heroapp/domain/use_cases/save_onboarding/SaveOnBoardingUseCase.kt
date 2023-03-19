package com.nickdferrara.ui_android_heroapp.domain.use_cases.save_onboarding

import com.nickdferrara.ui_android_heroapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}
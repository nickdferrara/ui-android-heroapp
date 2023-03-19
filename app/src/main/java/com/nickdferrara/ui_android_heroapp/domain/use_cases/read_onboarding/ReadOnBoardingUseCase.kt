package com.nickdferrara.ui_android_heroapp.domain.use_cases.read_onboarding

import com.nickdferrara.ui_android_heroapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingStatue()
    }
}
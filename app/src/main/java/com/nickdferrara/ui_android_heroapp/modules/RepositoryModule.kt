package com.nickdferrara.ui_android_heroapp.modules

import android.content.Context
import com.nickdferrara.ui_android_heroapp.data.repository.DataStore
import com.nickdferrara.ui_android_heroapp.data.repository.Repository
import com.nickdferrara.ui_android_heroapp.domain.interfaces.IDataStore
import com.nickdferrara.ui_android_heroapp.domain.use_cases.UseCases
import com.nickdferrara.ui_android_heroapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.nickdferrara.ui_android_heroapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): IDataStore {
        return DataStore(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases  {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }
}
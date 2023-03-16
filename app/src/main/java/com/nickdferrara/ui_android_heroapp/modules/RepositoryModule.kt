package com.nickdferrara.ui_android_heroapp.modules

import android.content.Context
import com.nickdferrara.ui_android_heroapp.data.preferences.DataStore
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
    fun provideDataStore(@ApplicationContext context: Context): DataStore {
        return DataStore(context = context)
    }
}
package com.nickdferrara.ui_android_heroapp.modules

import android.content.Context
import androidx.room.Room
import com.nickdferrara.ui_android_heroapp.data.local.BorutoDatabase
import com.nickdferrara.ui_android_heroapp.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BorutoDatabase::class.java,
        BORUTO_DATABASE
    ).build()
}
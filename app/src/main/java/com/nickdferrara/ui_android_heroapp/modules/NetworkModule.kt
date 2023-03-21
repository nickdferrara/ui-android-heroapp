package com.nickdferrara.ui_android_heroapp.modules

import androidx.paging.ExperimentalPagingApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nickdferrara.ui_android_heroapp.data.local.BorutoDatabase
import com.nickdferrara.ui_android_heroapp.data.remote.IBorutoApi
import com.nickdferrara.ui_android_heroapp.data.repository.RemoteDataSource
import com.nickdferrara.ui_android_heroapp.domain.interfaces.IRemoteDataSource
import com.nickdferrara.ui_android_heroapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideBorutoApi(retrofit: Retrofit): IBorutoApi {
        return retrofit.create(IBorutoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        borutoApi: IBorutoApi,
        borutoDatabase: BorutoDatabase
    ): IRemoteDataSource {
        return RemoteDataSource(
            borutoApi = borutoApi,
            borutoDatabase = borutoDatabase
        )
    }
}
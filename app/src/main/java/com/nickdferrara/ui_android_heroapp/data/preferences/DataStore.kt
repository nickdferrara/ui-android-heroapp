package com.nickdferrara.ui_android_heroapp.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.nickdferrara.ui_android_heroapp.domain.repository.interfaces.IDataStore
import com.nickdferrara.ui_android_heroapp.util.Constants.PREFERENCES_KEY
import com.nickdferrara.ui_android_heroapp.util.Constants.PREFERENCES_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

class DataStore(context: Context): IDataStore{
    private val dataStore = context.dataStore

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = isCompleted
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}
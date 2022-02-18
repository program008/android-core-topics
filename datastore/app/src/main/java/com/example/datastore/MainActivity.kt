package com.example.datastore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainActivity : AppCompatActivity() {
    // At the top level of your kotlin file:
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // read from a preferences datastore
    fun readPreferenceData(context: Context): Flow<Int> {
        val exampleCounterFlow: Flow<Int> = context.dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[EXAMPLE_COUNTER] ?: 0
            }
        return exampleCounterFlow
    }

    //write to a preferences datastore
    suspend fun writePreferenceData(context: Context, count: Int) {
        context.dataStore.edit { settings ->
            //val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = count
        }
    }

    //read from a proto datastore
    fun readProtoData(context: Context) {
        val exampleCounterFlow: Flow<Int> = context.settingsDataStore.data
            .map { settings ->
                // The exampleCounter property is generated from the proto schema.
                settings.exampleCounter
            }
    }
    //write to a proto datastore
    suspend fun incrementCounter(context: Context) {
        context.settingsDataStore.updateData { currentSettings ->
            currentSettings.toBuilder()
                .setExampleCounter(currentSettings.exampleCounter + 1)
                .build()
        }
    }
}
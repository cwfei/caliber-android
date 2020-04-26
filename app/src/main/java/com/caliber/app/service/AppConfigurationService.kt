package com.caliber.app.service

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import com.caliber.app.core.UserSharedPreferencesKeys
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppConfigurationService @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    var defaultNightMode: Int
        set(value) {
            AppCompatDelegate.setDefaultNightMode(value)

            sharedPreferences.edit {
                putInt(UserSharedPreferencesKeys.DefaultNightMode.name, value)
            }
        }
        get() {
            return sharedPreferences.getInt(
                UserSharedPreferencesKeys.DefaultNightMode.name,
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            )
        }
}

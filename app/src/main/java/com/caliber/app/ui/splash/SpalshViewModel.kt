package com.caliber.app.ui.splash

import android.app.UiModeManager
import androidx.lifecycle.ViewModel
import com.caliber.app.service.AppConfigurationService
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val appConfigurationService: AppConfigurationService
) : ViewModel() {

    val defaultNightMode: Int
        get() {
            return appConfigurationService.defaultNightMode
        }

    fun lol() {
        appConfigurationService.defaultNightMode = UiModeManager.MODE_NIGHT_YES
    }
}

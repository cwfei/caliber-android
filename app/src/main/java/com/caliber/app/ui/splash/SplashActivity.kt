package com.caliber.app.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.caliber.app.DaggerActivity
import com.caliber.app.MainActivity
import javax.inject.Inject

class SplashActivity : DaggerActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(SplashViewModel::class.java)
        AppCompatDelegate.setDefaultNightMode(viewModel.defaultNightMode)

        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
    }
}

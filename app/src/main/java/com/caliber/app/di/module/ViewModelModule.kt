package com.caliber.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.caliber.app.di.ViewModelFactory
import com.caliber.app.di.ViewModelKey
import com.caliber.app.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindMainViewMode(splashViewModel: SplashViewModel): ViewModel
}

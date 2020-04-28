package com.caliber.app.di.module

import com.caliber.app.MainActivity
import com.caliber.app.ui.splash.SplashActivity
import com.caliber.app.ui.watch.WatchEditorActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeWatchEditorActivity(): WatchEditorActivity
}

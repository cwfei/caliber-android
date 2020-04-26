package com.caliber.app.di.module

import androidx.fragment.app.Fragment
import com.caliber.app.ui.watch.WatchesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeWatchesFragment(): WatchesFragment
}

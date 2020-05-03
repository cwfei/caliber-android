package com.caliber.app.di.module

import androidx.fragment.app.Fragment
import com.caliber.app.ui.clock.ClockFragment
import com.caliber.app.ui.measurement.editor.MeasurementEditorFragment
import com.caliber.app.ui.watch.WatchesFragment
import com.caliber.app.ui.watch.editor.WatchEditorFragment
import com.caliber.app.ui.watch.viewer.WatchViewerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeClockFragment(): ClockFragment

    @ContributesAndroidInjector
    abstract fun contributeWatchesFragment(): WatchesFragment

    @ContributesAndroidInjector
    abstract fun contributeWatchEditorFragment(): WatchEditorFragment

    @ContributesAndroidInjector
    abstract fun contributeWatchViewerFragment(): WatchViewerFragment

    @ContributesAndroidInjector
    abstract fun contributeMeasurementEditorFragment(): MeasurementEditorFragment
}

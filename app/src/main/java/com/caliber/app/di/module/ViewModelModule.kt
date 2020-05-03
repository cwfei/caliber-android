package com.caliber.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.caliber.app.di.ViewModelFactory
import com.caliber.app.di.ViewModelKey
import com.caliber.app.ui.clock.ClockViewModel
import com.caliber.app.ui.measurement.editor.MeasurementEditorViewModel
import com.caliber.app.ui.splash.SplashViewModel
import com.caliber.app.ui.watch.WatchesViewModel
import com.caliber.app.ui.watch.editor.WatchEditorViewModel
import com.caliber.app.ui.watch.viewer.WatchViewerViewModel
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
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ClockViewModel::class)
    abstract fun bindClockViewModel(clockViewModel: ClockViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WatchesViewModel::class)
    abstract fun bindWatchesViewModel(watchesViewModel: WatchesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WatchEditorViewModel::class)
    abstract fun bindWatchEditorViewModel(watchEditorViewModel: WatchEditorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WatchViewerViewModel::class)
    abstract fun bindWatchViewerViewModel(watchViewerViewModel: WatchViewerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MeasurementEditorViewModel::class)
    abstract fun bindMeasurementEditorViewModel(measurementEditorViewModel: MeasurementEditorViewModel): ViewModel
}

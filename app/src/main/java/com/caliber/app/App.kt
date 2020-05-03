package com.caliber.app

import android.app.Application
import android.util.Log
import com.caliber.app.di.AppInjector
import com.instacart.library.truetime.TrueTimeRx
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

        TrueTimeRx.build()
            .withSharedPreferencesCache(this)
            .initializeRx("time.apple.com")
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}

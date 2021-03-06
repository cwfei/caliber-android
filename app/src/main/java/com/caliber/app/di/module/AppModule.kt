package com.caliber.app.di.module

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.caliber.app.BuildConfig
import com.caliber.app.database.AppDatabase
import com.caliber.app.database.MeasurementDao
import com.caliber.app.database.WatchDao
import com.caliber.app.service.FormatterService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase {
        return Room
            .databaseBuilder(
                app,
                AppDatabase::class.java,
                BuildConfig.APPLICATION_ID + ".database"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideWatchDao(database: AppDatabase): WatchDao {
        return database.watchDao()
    }

    @Singleton
    @Provides
    fun provideReminderDao(database: AppDatabase): MeasurementDao {
        return database.measurementDao()
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(app: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app)
    }

    @Provides
    fun provideFormatterService(): FormatterService = FormatterService()
}

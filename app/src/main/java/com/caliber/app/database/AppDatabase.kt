package com.caliber.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.caliber.app.model.Measurement
import com.caliber.app.model.Watch

@Database(
    entities = [Watch::class, Measurement::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun watchDao(): WatchDao

    abstract fun measurementDao(): MeasurementDao
}

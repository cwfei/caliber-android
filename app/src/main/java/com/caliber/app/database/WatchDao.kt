package com.caliber.app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.caliber.app.model.Watch

@Dao
interface WatchDao {
    @Query("SELECT * FROM Watch")
    suspend fun getWatches(): List<Watch>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWatch(watch: Watch)
}

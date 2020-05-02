package com.caliber.app.service

import com.caliber.app.database.WatchDao
import com.caliber.app.model.Watch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WatchService @Inject constructor(
    private val watchDao: WatchDao
) {

    suspend fun insertWatch(watch: Watch) {
        watchDao.insertWatch(watch)
    }
}

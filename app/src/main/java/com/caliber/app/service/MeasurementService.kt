package com.caliber.app.service

import com.caliber.app.database.MeasurementDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MeasurementService @Inject constructor(
    private val measurementDao: MeasurementDao
) {

}

package com.caliber.app.ui.measurement.editor

import androidx.lifecycle.ViewModel
import com.caliber.app.service.MeasurementService
import com.caliber.app.service.TimeService
import com.instacart.library.truetime.TrueTimeRx
import javax.inject.Inject

class MeasurementEditorViewModel @Inject constructor(
    private val measurementService: MeasurementService,
    private val timeService: TimeService
) : ViewModel() {

    val closestMillisToNextSecond: Long
        get() {
            return timeService.closestMillisToNextSecond
        }

    val formattedDateText: String
        get() {
            return timeService.formattedNow
        }
}

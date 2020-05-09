package com.caliber.app.ui.measurement.editor

import android.app.Application
import androidx.lifecycle.ViewModel
import com.caliber.app.R
import com.caliber.app.service.MeasurementService
import com.caliber.app.service.TimeService
import com.instacart.library.truetime.TrueTimeRx
import java.text.DecimalFormat
import java.util.*
import javax.inject.Inject

class MeasurementEditorViewModel @Inject constructor(
    private val application: Application,
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

    val currentDeviationText: String
        get() {
            val formatter = DecimalFormat("#.#")
            val secondsDifference = (selectedDate.time - timeService.now.time) / 1000.0
            return if (secondsDifference > 0) {
                application.getString(
                    R.string.total_seconds,
                    "+${formatter.format(secondsDifference)}"
                )
            } else {
                application.getString(
                    R.string.total_seconds,
                    formatter.format(secondsDifference)
                )
            }
        }

    // Currently selected measurement date.
    var selectedDate: Date = {
        // Set initial date to next minute sharp.
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 1)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.time
    }()

    fun selectDate(date: Date) {
        this.selectedDate = date
    }
}

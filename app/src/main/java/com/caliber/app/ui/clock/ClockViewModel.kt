package com.caliber.app.ui.clock

import android.app.Application
import androidx.lifecycle.ViewModel
import com.caliber.app.R
import com.caliber.app.service.FormatterService
import com.caliber.app.service.TimeService
import com.instacart.library.truetime.TrueTimeRx
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class ClockViewModel @Inject constructor(
    private val application: Application,
    private val timeService: TimeService
) : ViewModel() {

    private val formatter = SimpleDateFormat.getTimeInstance()

    val closestMillisToNextSecond: Long
        get() {
            return timeService.closestMillisToNextSecond
        }

    val formattedDateText: String
        get() {
            return timeService.formattedNow
        }

    val timeDifferencesText: String
        get() {
            val deviceDate = Calendar.getInstance().time
            val ntpDate = TrueTimeRx.now()
            val millisDifferences = ntpDate.time - deviceDate.time

            return if (millisDifferences >= 0) {
                application.getString(
                    R.string.msg_millis_ahead_system_clock,
                    millisDifferences.toString()
                )
            } else {
                application.getString(
                    R.string.msg_millis_behind_system_clock,
                    millisDifferences.toString()
                )
            }
        }
}

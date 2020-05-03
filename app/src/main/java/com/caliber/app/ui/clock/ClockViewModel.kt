package com.caliber.app.ui.clock

import android.app.Application
import androidx.lifecycle.ViewModel
import com.caliber.app.R
import com.instacart.library.truetime.TrueTimeRx
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class ClockViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {

    private val formatter = SimpleDateFormat.getTimeInstance()

    val closestMillisToNextSecond: Long
        get() {
            return 1_000 - TrueTimeRx.now()
                .time
                .toString()
                .takeLast(3)
                .toLong()
        }

    val formattedDateText: String
        get() {
            return formatter.format(TrueTimeRx.now())
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

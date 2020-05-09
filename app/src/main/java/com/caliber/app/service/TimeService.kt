package com.caliber.app.service

import android.app.Application
import com.instacart.library.truetime.TrueTimeRx
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeService @Inject constructor(private val formatterService: FormatterService) {

    val closestMillisToNextSecond: Long
        get() {
            return 1_000 - TrueTimeRx.now()
                .time
                .toString()
                .takeLast(3)
                .toLong()
        }

    val now: Date
        get() {
            return TrueTimeRx.now()
        }

    val formattedNow: String
        get() {
            return formatterService.timeFormatter.format(now)
        }
}

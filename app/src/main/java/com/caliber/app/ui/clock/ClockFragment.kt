package com.caliber.app.ui.clock

import android.os.Bundle
import android.text.format.DateUtils
import android.text.format.DateUtils.SECOND_IN_MILLIS
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope

import com.caliber.app.R
import com.instacart.library.truetime.TrueTimeRx
import kotlinx.android.synthetic.main.fragment_clock.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class ClockFragment : Fragment() {

    private val formatter = SimpleDateFormat.getTimeInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleTextView.text = getString(R.string.atomic_clock)

        lifecycleScope.launch {
            while (true) {
                delay(
                    1000 - TrueTimeRx.now()
                        .time
                        .toString()
                        .takeLast(3)
                        .toLong()
                )

                updateViews()
            }
        }

        updateViews()
    }

    private fun updateViews() {
        if (!TrueTimeRx.isInitialized()) {
            return
        }

        val deviceTime = Calendar.getInstance().time
        val trueTime = TrueTimeRx.now()
        val millisDifference = trueTime.time - deviceTime.time

        dateTextView.text = formatter.format(trueTime)
        timeDifferentTextView.text = "${millisDifference} ms behind system clock"
    }
}

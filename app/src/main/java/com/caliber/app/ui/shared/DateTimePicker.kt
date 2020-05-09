package com.caliber.app.ui.shared

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.caliber.app.R
import kotlinx.android.synthetic.main.layout_date_time_picker.view.*
import java.util.*

class DateTimePicker : ConstraintLayout {

    interface OnValueChangedListener {
        fun onValueChanged(picker: DateTimePicker, date: Date)
    }

    var onValueChangedListener: OnValueChangedListener? = null

    private val amPmDisplayedValues = arrayOf("AM", "PM")

    constructor(context: Context) : super(context) {
        sharedInit()
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        sharedInit()
    }

    var selectedDate: Date = Date()
        private set

    private fun sharedInit() {
        inflate(context, R.layout.layout_date_time_picker, this)

        hourPicker.setOnValueChangedListener { _, _, _ ->
            onValueChanged()
        }
        minutePicker.setOnValueChangedListener { _, _, _ ->
            onValueChanged()
        }
        secondPicker.setOnValueChangedListener { _, _, _ ->
            onValueChanged()
        }
        amPmPicker.setOnValueChangedListener { _, _, _ ->
            onValueChanged()
        }

        configureViews()
    }

    fun setInitialDate(date: Date) {
        this.selectedDate = date

        val calendar = Calendar.getInstance()
        calendar.time = date

        hourPicker.value = calendar.get(Calendar.HOUR)
        minutePicker.value = calendar.get(Calendar.MINUTE)
        secondPicker.value = calendar.get(Calendar.SECOND)
        amPmPicker.value = calendar.get(Calendar.AM_PM)
    }

    private fun configureViews() {
        // Minute.
        val minuteDisplayedValues = (0..59).map {
            String.format("%02d", it)
        }.toTypedArray()
        minutePicker.minValue = 0
        minutePicker.maxValue = minuteDisplayedValues.size - 1
        minutePicker.displayedValues = minuteDisplayedValues

        // Second.
        val secondDisplayedValues = (0..59).map {
            String.format("%02d", it)
        }.toTypedArray()
        secondPicker.minValue = 0
        secondPicker.maxValue = secondDisplayedValues.size - 1
        secondPicker.displayedValues = secondDisplayedValues

        // AM PM.
        amPmPicker.minValue = 0
        amPmPicker.maxValue = 1
        amPmPicker.displayedValues = amPmDisplayedValues
    }

    private fun onValueChanged() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR, hourPicker.value)
        calendar.set(Calendar.MINUTE, minutePicker.value)
        calendar.set(Calendar.SECOND, secondPicker.value)
        calendar.set(Calendar.AM_PM, amPmPicker.value)
        calendar.set(Calendar.MILLISECOND, 0)

        selectedDate = calendar.time
        onValueChangedListener?.onValueChanged(this, calendar.time)
    }
}

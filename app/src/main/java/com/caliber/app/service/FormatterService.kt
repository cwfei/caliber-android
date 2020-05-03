package com.caliber.app.service

import java.text.DateFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FormatterService {

    val timeFormatter: DateFormat = {
        val dateFormat = DateFormat.getTimeInstance()
        dateFormat
    }()
}

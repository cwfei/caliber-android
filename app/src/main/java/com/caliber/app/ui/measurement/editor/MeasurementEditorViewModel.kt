package com.caliber.app.ui.measurement.editor

import androidx.lifecycle.ViewModel
import com.caliber.app.service.MeasurementService
import javax.inject.Inject

class MeasurementEditorViewModel @Inject constructor(
    private val measurementService: MeasurementService
) : ViewModel() {

}

package com.caliber.app.ui.watch.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caliber.app.model.Watch
import com.caliber.app.model.params.WatchBuilder
import com.caliber.app.service.WatchService
import kotlinx.coroutines.launch
import javax.inject.Inject

class WatchEditorViewModel @Inject constructor(
    private val watchService: WatchService
) : ViewModel() {

    val builder = WatchBuilder()

    fun save() {
        viewModelScope.launch {
            val watch = builder.build()
            watchService.insertWatch(watch)
        }
    }

    fun isValidForProceeding(): Boolean {
        return !builder.brand.isNullOrEmpty()
    }
}

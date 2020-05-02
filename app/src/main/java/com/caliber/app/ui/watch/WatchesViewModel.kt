package com.caliber.app.ui.watch

import androidx.lifecycle.ViewModel
import com.caliber.app.model.Watch
import com.caliber.app.service.WatchService
import javax.inject.Inject

class WatchesViewModel @Inject constructor(
    private val watchService: WatchService
) : ViewModel() {

    suspend fun getWatches() : List<Watch>{
        return watchService.getWatches()
    }
}

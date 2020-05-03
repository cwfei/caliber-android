package com.caliber.app.ui.watch.viewer

import androidx.lifecycle.ViewModel
import com.caliber.app.service.WatchService
import javax.inject.Inject

class WatchViewerViewModel @Inject constructor(
    private val watchService: WatchService
) : ViewModel() {

}

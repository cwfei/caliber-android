package com.caliber.app.ui.clock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import com.caliber.app.R
import com.caliber.app.di.Injectable
import com.caliber.app.ui.watch.editor.WatchEditorViewModel
import com.instacart.library.truetime.TrueTimeRx
import kotlinx.android.synthetic.main.fragment_clock.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class ClockFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ClockViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ClockViewModel::class.java)
        titleTextView.text = getString(R.string.atomic_clock)

        lifecycleScope.launch {
            while (true) {
                delay(viewModel.closestMillisToNextSecond)
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

        dateTextView.text = viewModel.formattedDateText
        timeDifferencesTextView.text = viewModel.timeDifferencesText
    }
}

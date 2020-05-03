package com.caliber.app.ui.measurement.editor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import com.caliber.app.R
import com.caliber.app.di.Injectable
import com.instacart.library.truetime.TrueTimeRx
import kotlinx.android.synthetic.main.fragment_measurement_editor.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MeasurementEditorFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MeasurementEditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_measurement_editor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MeasurementEditorViewModel::class.java)
        backButton.setOnClickListener { requireActivity().finish() }

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

        dateTextView.text = viewModel.formattedDateText
    }
}

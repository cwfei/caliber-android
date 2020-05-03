package com.caliber.app.ui.watch.viewer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider

import com.caliber.app.R
import com.caliber.app.core.Keys
import com.caliber.app.di.Injectable
import com.caliber.app.ui.measurement.editor.MeasurementEditorActivity
import com.caliber.app.ui.measurement.editor.MeasurementEditorViewModel
import kotlinx.android.synthetic.main.fragment_watch_viewer.*
import javax.inject.Inject

class WatchViewerFragment : Fragment(), Injectable {

    companion object {
        fun create(watchId: String, title: String): WatchViewerFragment {
            return WatchViewerFragment().apply {
                arguments = bundleOf(
                    Keys.WatchViewer.watchId to watchId,
                    Keys.WatchViewer.title to title
                )
            }
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: WatchViewerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_watch_viewer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(WatchViewerViewModel::class.java)
        titleTextView.text = arguments?.getString(Keys.WatchViewer.title)

        backButton.setOnClickListener { requireActivity().finish() }
        addButton.setOnClickListener {
            val intent = Intent(requireContext(), MeasurementEditorActivity::class.java)
            startActivity(intent)
        }
    }
}

package com.caliber.app.ui.watch.editor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.caliber.app.R
import com.caliber.app.di.Injectable
import kotlinx.android.synthetic.main.fragment_watch_editor.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

class WatchEditorFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: WatchEditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_watch_editor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(WatchEditorViewModel::class.java)
        backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        saveButton.setOnClickListener { onSave() }
    }

    private fun onSave() {

    }
}

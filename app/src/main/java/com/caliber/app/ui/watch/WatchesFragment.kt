package com.caliber.app.ui.watch

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.caliber.app.R
import com.caliber.app.di.Injectable
import com.caliber.app.ui.watch.editor.WatchEditorActivity
import kotlinx.android.synthetic.main.fragment_watches.*
import kotlinx.android.synthetic.main.layout_toolbar.titleTextView
import javax.inject.Inject

class WatchesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: WatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_watches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(WatchesViewModel::class.java)
        titleTextView.text = getString(R.string.watches)
        addButton.setOnClickListener {
            val intent = Intent(requireActivity(), WatchEditorActivity::class.java)
            startActivity(intent)
        }
    }
}

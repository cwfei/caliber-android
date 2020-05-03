package com.caliber.app.ui.watch

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.caliber.app.R
import com.caliber.app.di.Injectable
import com.caliber.app.model.Watch
import com.caliber.app.ui.watch.editor.WatchEditorActivity
import kotlinx.android.synthetic.main.fragment_watches.*
import kotlinx.android.synthetic.main.layout_toolbar.titleTextView
import kotlinx.coroutines.launch
import javax.inject.Inject

class WatchesFragment : Fragment(), Injectable, WatchesAdapter.Listener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: WatchesViewModel

    private val adapter = WatchesAdapter()

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

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        adapter.listener = this

        lifecycleScope.launch {
            adapter.items = viewModel.getWatches()
        }
    }

    override fun onViewWatch(watch: Watch) {

    }
}

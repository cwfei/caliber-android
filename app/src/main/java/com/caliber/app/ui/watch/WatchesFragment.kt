package com.caliber.app.ui.watch

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import com.caliber.app.R
import com.caliber.app.core.Keys
import com.caliber.app.di.Injectable
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.fragment_watches.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
            val fragment = WatchEditorSheetFragment()
            fragment.show(childFragmentManager, "")
        }
    }

    private fun onAddWatch() {
        val intent = Intent(requireActivity(), WatchEditorActivity::class.java)
        intent.putExtra(Keys.WatchEditor.TransitionName.name, addButton.transitionName)
        val options = ActivityOptions.makeSceneTransitionAnimation(
            requireActivity(),
            addButton,
            addButton.transitionName
        )
        startActivity(intent, options.toBundle())
    }
}

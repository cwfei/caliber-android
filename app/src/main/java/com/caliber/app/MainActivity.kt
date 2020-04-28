package com.caliber.app

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import androidx.annotation.NonNull
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.caliber.app.ui.clock.ClockFragment
import com.caliber.app.ui.watch.WatchEditorActivity
import com.caliber.app.ui.watch.WatchEditorFragment
import com.caliber.app.ui.watch.WatchesFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import com.remido.app.util.TAG
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        private val TAG_TO_FRAGMENT_FACTORY_FUNCTION = mapOf<String, () -> Fragment>(
            ClockFragment::class.java.simpleName to { ClockFragment() },
            WatchesFragment::class.java.simpleName to { WatchesFragment() }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected)
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_clock
        }
    }

    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_clock -> {
                presentFragment(ClockFragment::class.java.simpleName)
            }

            R.id.navigation_watches -> {
                presentFragment(WatchesFragment::class.java.simpleName)
            }
        }

        bottomNavigationView.menu.forEach {
            it.isChecked = it.itemId == item.itemId
        }

        return true
    }

    private fun presentFragment(tag: String) {
        if (!TAG_TO_FRAGMENT_FACTORY_FUNCTION.containsKey(tag)) {
            throw Error("tag does not specify a valid fragment")
        }

        val transaction = supportFragmentManager.beginTransaction()

        // Hide fragments that are not the one being shown.
        TAG_TO_FRAGMENT_FACTORY_FUNCTION.keys.filter { it != tag }.forEach { it ->
            supportFragmentManager.findFragmentByTag(it)?.let { transaction.hide(it) }
        }

        // Show or create the desired fragment.
        supportFragmentManager.findFragmentByTag(tag).let {
            if (it == null) {
                val fragment = TAG_TO_FRAGMENT_FACTORY_FUNCTION[tag]!!()
                transaction.add(R.id.fragmentContainerView, fragment, tag)
            } else {
                transaction.show(it)
            }
        }

        transaction.commit()
    }
}

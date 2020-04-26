package com.caliber.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.caliber.app.ui.ClockFragment
import com.caliber.app.ui.WatchesFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Clock

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    companion object {
        private val TAG_TO_FRAGMENT_FACTORY_FUNCTION = mapOf<String, () -> Fragment>(
            ClockFragment::class.java.simpleName to { ClockFragment() },
            WatchesFragment::class.java.simpleName to { WatchesFragment() }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected)
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

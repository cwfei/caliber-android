package com.caliber.app.ui.watch.viewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.caliber.app.DaggerActivity
import com.caliber.app.core.Keys

class WatchViewerActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragment = WatchViewerFragment.create(
            watchId = requireNotNull(intent.getStringExtra(Keys.WatchViewer.watchId)),
            title = requireNotNull(intent.getStringExtra(Keys.WatchViewer.title))
        )

        supportFragmentManager.commit {
            add(android.R.id.content, fragment)
        }
    }
}

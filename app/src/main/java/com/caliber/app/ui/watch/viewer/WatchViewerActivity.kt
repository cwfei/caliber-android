package com.caliber.app.ui.watch.viewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.caliber.app.DaggerActivity

class WatchViewerActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            add(android.R.id.content, WatchViewerFragment())
        }
    }
}

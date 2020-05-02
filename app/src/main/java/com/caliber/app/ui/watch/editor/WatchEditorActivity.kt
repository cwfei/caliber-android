package com.caliber.app.ui.watch.editor

import android.os.Bundle
import androidx.fragment.app.commit
import com.caliber.app.BaseActivity

class WatchEditorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            add(android.R.id.content, WatchEditorFragment())
        }
    }
}

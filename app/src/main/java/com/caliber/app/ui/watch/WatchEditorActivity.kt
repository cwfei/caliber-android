package com.caliber.app.ui.watch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.caliber.app.BaseActivity
import com.caliber.app.R
import com.caliber.app.core.Keys
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WatchEditorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        findViewById<View>(android.R.id.content).transitionName =
            intent.extras?.getString(Keys.WatchEditor.TransitionName.name)
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
        }

        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            add(android.R.id.content, WatchEditorFragment())
        }
    }
}

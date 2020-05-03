package com.caliber.app.ui.measurement.editor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.caliber.app.DaggerActivity

class MeasurementEditorActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            add(android.R.id.content, MeasurementEditorFragment())
        }
    }
}

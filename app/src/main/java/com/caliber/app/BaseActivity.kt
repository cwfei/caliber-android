package com.caliber.app

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.caliber.app.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val typedValue = TypedValue()
        theme.resolveAttribute(R.attr.colorSurface, typedValue, true)
        if (isColorLight(typedValue.data)) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

    private fun isColorLight(@ColorInt color: Int): Boolean {
        return color != Color.TRANSPARENT && ColorUtils.calculateLuminance(color) > 0.5
    }
}

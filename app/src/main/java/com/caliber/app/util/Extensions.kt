package com.remido.app.util

import android.content.res.Resources
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Patterns
import android.util.TypedValue
import android.view.View

// General purpose extensions

val Any.TAG: String
    get() {
        return this.javaClass.simpleName
    }

fun Byte.clampTo(min: Byte, max: Byte): Byte {
    return maxOf(min, minOf(this, max))
}

fun Double.clampTo(min: Double, max: Double): Double {
    return maxOf(min, minOf(this, max))
}

fun Float.clampTo(min: Float, max: Float): Float {
    return maxOf(min, minOf(this, max))
}

fun Int.clampTo(min: Int, max: Int): Int {
    return maxOf(min, minOf(this, max))
}

fun Long.clampTo(min: Long, max: Long): Long {
    return maxOf(min, minOf(this, max))
}

fun Short.clampTo(min: Short, max: Short): Short {
    return maxOf(min, minOf(this, max))
}

fun String.isEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

// Functional extensions

/**
 *  Executes the given block if the receiver is null or returns the receiver as a non-null type otherwise. The guard
 *  block must return from the enclosing function.
 */
inline fun <T, R> T?.guard(block: () -> R): T {
    if (this == null) {
        block()
        throw IllegalArgumentException("guard block must return from enclosing function")
    }

    return this
}

fun <T> T?.isAnyOf(vararg ts: T): Boolean {
    if (this == null) {
        return false
    }

    return ts.contains(this)
}

// Thread extensions

private object MainHandlerHolder {
    val handler = Handler(Looper.getMainLooper())
}

fun onMain(runnable: Runnable) {
    MainHandlerHolder.handler.post(runnable)
}

fun <R> onMain(block: () -> R) {
    MainHandlerHolder.handler.post(Runnable { block() })
}

// Views

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        // We're already attached, just request as normal
        requestApplyInsets()
    } else {
        // We're not attached to the hierarchy, add a listener to
        // request when we are
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

fun dipToPixels(dip: Int): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip.toFloat(), displayMetrics).toInt()
}

fun dipToPixels(dip: Float): Int {
    val displayMetrics = Resources.getSystem().displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics).toInt()
}

fun pixelsToDip(pixels: Int): Float {
    val displayMetrics = Resources.getSystem().displayMetrics
    return pixels / (displayMetrics.densityDpi / 160f)
}

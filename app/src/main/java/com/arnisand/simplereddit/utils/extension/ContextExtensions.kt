package com.arnisand.simplereddit.utils.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    showToast(resources.getString(resId), duration)
}
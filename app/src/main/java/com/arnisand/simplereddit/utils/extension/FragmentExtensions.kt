package com.arnisand.simplereddit.utils.extension

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    context?.showToast(message, duration)
}

fun Fragment.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    context?.showToast(resId, duration)
}
package com.arnisand.simplereddit.utils.extension

import android.os.SystemClock
import android.view.View

const val THROTTLE_TIME = 500

fun View.setOnClickThrottleListener(onClickListener: View.OnClickListener?) {
    setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < THROTTLE_TIME) {
                return
            }
            onClickListener?.onClick(v)
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun View.setOnClickThrottleListener(action: (() -> Unit)?) {
    setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < THROTTLE_TIME) {
                return
            }
            action?.invoke()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

package com.arnisand.simplereddit.utils.extension

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.arnisand.simplereddit.R
import kotlin.reflect.KClass

fun AppCompatActivity.addFragmentToContainer(
    fragment: Fragment,
    @IdRes layoutId: Int = R.id.frameLayoutContainer
) {
    supportFragmentManager.findFragmentByTag(fragment::class.java.name)?.takeIf {
        it.isVisible
    } ?: let {
        supportFragmentManager
            .beginTransaction()
            .replace(layoutId, fragment, fragment::class.java.name)
            .addToBackStack(fragment::class.java.name)
            .commit()
    }
}

fun AppCompatActivity.addFragmentToContainerWithoutBackStack(
    fragment: Fragment,
    @IdRes layoutId: Int = R.id.frameLayoutContainer
) {
    supportFragmentManager
        .beginTransaction()
        .replace(layoutId, fragment, fragment::class.java.name)
        .commitNow()
}

fun AppCompatActivity.clearBackStack(kClass: KClass<out Fragment>? = null) {
    supportFragmentManager
        .popBackStack(kClass?.java?.name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}
package com.arnisand.simplereddit.utils.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified VM : ViewModel> Fragment.obtainViewModel(factory: ViewModelProvider.Factory): VM {
    return ViewModelProvider(this, factory).get(VM::class.java)
}

inline fun <reified VM : ViewModel> Fragment.obtainActivityViewModel(factory: ViewModelProvider.Factory): VM {
    return requireActivity().obtainViewModel(factory)
}

inline fun <reified VM : ViewModel> FragmentActivity.obtainViewModel(factory: ViewModelProvider.Factory): VM {
    return ViewModelProvider(this, factory).get(VM::class.java)
}
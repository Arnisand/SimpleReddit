package com.arnisand.simplereddit.ui.main

import android.os.Bundle
import com.arnisand.simplereddit.R
import com.arnisand.simplereddit.ui.base.BaseActivity
import com.arnisand.simplereddit.utils.extension.addFragmentToContainerWithoutBackStack
import com.arnisand.simplereddit.utils.extension.obtainViewModel
import dagger.android.AndroidInjection

class MainActivity : BaseActivity(R.layout.activity_main) {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        savedInstanceState ?: addFragmentToContainerWithoutBackStack(TopArticlesFragment.newInstance())
        mainViewModel = obtainViewModel(viewModelFactory)
    }
}

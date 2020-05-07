package com.arnisand.simplereddit.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.arnisand.simplereddit.R
import com.arnisand.simplereddit.utils.extension.obtainActivityViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TopArticlesFragment : Fragment(R.layout.fragment_top_articles) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = obtainActivityViewModel(viewModelFactory)
    }

    companion object {
        fun newInstance() = TopArticlesFragment()
    }
}
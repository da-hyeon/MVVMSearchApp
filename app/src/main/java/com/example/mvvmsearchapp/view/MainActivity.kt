package com.example.mvvmsearchapp.view

import com.example.mvvmsearchapp.R
import com.example.mvvmsearchapp.base.BaseKotlinActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.mvvmsearchapp.databinding.ActivityMainBinding
import com.example.mvvmsearchapp.viewmodel.MainViewModel

class MainActivity : BaseKotlinActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}

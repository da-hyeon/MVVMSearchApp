package com.example.mvvmsearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmsearchapp.databinding.ActivityMainBinding

class MainActivity : BaseKotlinActivity<ActivityMainBinding , MainViewModel>() {

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

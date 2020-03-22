package com.example.mvvmsearchapp

import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import com.example.mvvmsearchapp.di.myDiModule
import com.example.mvvmsearchapp.model.DataModel
import com.example.mvvmsearchapp.model.DataModelImpl
import com.example.mvvmsearchapp.viewmodel.MainViewModel
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext , myDiModule)
    }
}
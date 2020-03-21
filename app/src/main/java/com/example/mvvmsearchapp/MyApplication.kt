package com.example.mvvmsearchapp

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext , myDiModule)
    }

    var modelPart = module {
        factory<DataModel> {
            DataModelImpl()
        }
    }

    var viewModelPart = module {
        viewModel {
            MainViewModel(get())
        }
    }

    var myDiModule = listOf(modelPart , viewModelPart)
}
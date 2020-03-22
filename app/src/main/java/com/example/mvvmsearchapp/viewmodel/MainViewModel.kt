package com.example.mvvmsearchapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmsearchapp.model.DataModel
import com.example.mvvmsearchapp.base.BaseKotlinViewModel
import com.example.mvvmsearchapp.model.enum.KakaoSearchSortEnum
import com.example.mvvmsearchapp.model.response.ImageSearchResponse
import com.example.mvvmsearchapp.model.service.KakaoSearchService
import com.example.mvvmsearchapp.util.SingleLiveEvent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model: DataModel) : BaseKotlinViewModel() {

    private val TAG = "MainViewModel"

    //외부에서는 Livedata를 변경하지 못하게 하고, 내부에서는 변경이 가능하게 하기 위한 구현
    private val _imageSearchResponseLiveData = MutableLiveData<ImageSearchResponse>()
    val imageSearchResponseLiveData: LiveData<ImageSearchResponse>
        get() = _imageSearchResponseLiveData

    fun getImageSearch(query: String, page: Int, size: Int) {
        addDisposable(
            model.getData(query, KakaoSearchSortEnum.Accuracy, page, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.run {
                        if (documents.size > 0) {
                            Log.d(TAG , "documents : $documents")
                            _imageSearchResponseLiveData.postValue(this)
                        }
                        Log.d(TAG , "meta : $meta")
                    }
                }, {
                    Log.d(TAG, "response error, message : ${it.message}")
                })
        )
    }
}
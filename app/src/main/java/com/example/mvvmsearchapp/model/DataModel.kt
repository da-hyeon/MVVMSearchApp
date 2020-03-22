package com.example.mvvmsearchapp.model

import com.example.mvvmsearchapp.model.enum.KakaoSearchSortEnum
import com.example.mvvmsearchapp.model.response.ImageSearchResponse
import io.reactivex.Single

interface DataModel {
    fun getData(query:String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse>
}
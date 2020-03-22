package com.example.mvvmsearchapp.model

import com.example.mvvmsearchapp.model.enum.KakaoSearchSortEnum
import com.example.mvvmsearchapp.model.response.ImageSearchResponse
import com.example.mvvmsearchapp.model.service.KakaoSearchService
import io.reactivex.Single

class DataModelImpl(private val service : KakaoSearchService): DataModel {

    private val KAKAO_APP_KEY = "575098708f9a15bd40f455d27d5f30b8"
    override fun getData(query:String, sort: KakaoSearchSortEnum, page:Int, size:Int): Single<ImageSearchResponse> {
        return service.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = query, sort = sort.sort, page = page, size = size)
    }
}
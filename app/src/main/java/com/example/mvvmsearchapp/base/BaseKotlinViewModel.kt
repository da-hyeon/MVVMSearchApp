package com.example.mvvmsearchapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseKotlinViewModel : ViewModel() {
    /**
     * RxJava 의 observing을 위한 부분.
     * addDisposable을 이용하여 추가하기만 하면 된다
     */
    //RxJava의 Observable들은 compositeDisposable에 추가하기 위함
    //뷰모델이 없어질 때 추가했던 것들을 지워줘야함
    private val compositeDisposable = CompositeDisposable()

    //
    fun addDisposable(disposable: Disposable){
        //Observable들을 옵저빙할때 추가
        compositeDisposable.add(disposable)
    }

    // ViewModel은 View와의 생명주기를 공유하기 때문에 View가 부서질 때 ViewModel의 onCleared()가 호출
    override fun onCleared() {
        //옵저버블들 전부 클리어
        compositeDisposable.clear()
        super.onCleared()
    }
}
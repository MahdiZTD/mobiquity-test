package com.mobiquity.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference


/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

abstract class BaseViewModel<N> : ViewModel() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var mNavigator: WeakReference<N>

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}
package com.mobiquity.productlist

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.mobiquity.base.BaseViewModel
import com.mobiquity.datamodel.CategoryModel
import com.mobiquity.network.ApiHelper
import com.mobiquity.utils.SchedulersProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

class ProductListViewModel(var apiHelper: ApiHelper,var schedulersProvider: SchedulersProvider) : BaseViewModel<ProductListNavigator>() {

    val categories: ObservableList<CategoryModel> = ObservableArrayList<CategoryModel>()
    val categoryLiveData: MutableLiveData<MutableList<CategoryModel>> = MutableLiveData()


    fun getProducts() {
        compositeDisposable.add(
            apiHelper.getProductList()
                .observeOn(schedulersProvider.ui())
                .subscribeOn(schedulersProvider.io())
                .subscribe(
                    {
                        categoryLiveData.value = it
                    },
                    {
                        Log.d("error", it.stackTrace.toString())
                    }
                )
        )
    }
}
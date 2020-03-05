package com.mobiquity.network

import com.mobiquity.datamodel.CategoryModel
import io.reactivex.Single
import retrofit2.http.GET


/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
interface ApiInterface {

    @GET("/")
    fun getProductList():Single<MutableList<CategoryModel>>

}
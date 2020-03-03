package com.mobiquity.network

import com.mobiquity.datamodel.CategoryModel
import io.reactivex.Single
import retrofit2.http.GET


/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 1/22/2019.
 */
interface ApiInterface {

    @GET("/")
    fun getProductList():Single<MutableList<CategoryModel>>

}
package com.mobiquity.network

import com.mobiquity.datamodel.CategoryModel
import com.truetechteam.aba.infrustructure.network.ApiRepository
import io.reactivex.Single

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
interface ApiHelper {
    fun getProductList(): Single<MutableList<CategoryModel>>
}

class ApiHelperImp : ApiHelper {
    override fun getProductList(): Single<MutableList<CategoryModel>> {
        return ApiRepository()
            .getRetrofit()
            .create(ApiInterface::class.java)
            .getProductList()
    }

}
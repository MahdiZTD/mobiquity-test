package com.mobiquity.productlist

import androidx.lifecycle.ViewModelProvider
import com.mobiquity.di.ViewModelProviderFactory
import com.mobiquity.network.ApiHelper
import com.mobiquity.network.ApiHelperImp
import com.mobiquity.productlist.adpter.ProductListAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

@Module
class ProductListModule {
    @Provides
    fun provideViewModel(productListViewModel: ProductListViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(productListViewModel)

    @Provides
    fun provideProductListViewModel(apiHelper: ApiHelper): ProductListViewModel = ProductListViewModel(apiHelper)

    @Provides
    fun provideApiHelper():ApiHelper = ApiHelperImp()

    @Provides
    fun provideAdapter():ProductListAdapter = ProductListAdapter(arrayListOf())

}
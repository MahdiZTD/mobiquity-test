package com.mobiquity.productlist

import androidx.lifecycle.ViewModelProvider
import com.mobiquity.di.ViewModelProviderFactory
import com.mobiquity.network.ApiHelper
import com.mobiquity.network.ApiHelperImp
import com.mobiquity.productlist.adpter.ProductListAdapter
import com.mobiquity.utils.AppSchedulerProvider
import com.mobiquity.utils.SchedulersProvider
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
    fun provideProductListViewModel(apiHelper: ApiHelper,schedulersProvider: SchedulersProvider): ProductListViewModel = ProductListViewModel(apiHelper,schedulersProvider)

    @Provides
    fun provideApiHelper():ApiHelper = ApiHelperImp()

    @Provides
    fun provideAdapter():ProductListAdapter = ProductListAdapter(arrayListOf())

    @Provides
    fun provideSchedulerProvider():SchedulersProvider = AppSchedulerProvider()

}
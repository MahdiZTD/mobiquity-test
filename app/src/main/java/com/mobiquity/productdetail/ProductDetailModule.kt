package com.mobiquity.productdetail

import androidx.lifecycle.ViewModelProvider
import com.mobiquity.di.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

@Module
class ProductDetailModule {

    @Provides
    fun provideViewModel(productDetailViewModel: ProductDetailViewModel): ViewModelProvider.Factory =
        ViewModelProviderFactory(productDetailViewModel)

    @Provides
    fun provideProductDetailViewModel(): ProductDetailViewModel = ProductDetailViewModel()

}
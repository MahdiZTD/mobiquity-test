package com.mobiquity.di

import com.mobiquity.productdetail.ProductDetailActivity
import com.mobiquity.productdetail.ProductDetailModule
import com.mobiquity.productlist.ProductListActivity
import com.mobiquity.productlist.ProductListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

@Module
abstract class ContributorsModule {

    @ContributesAndroidInjector(modules = [ProductListModule::class])
    abstract fun bindProductListActivity(): ProductListActivity

    @ContributesAndroidInjector(modules = [ProductDetailModule::class])
    abstract fun bindProductDetailActivity(): ProductDetailActivity

}
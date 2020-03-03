package com.mobiquity.productdetail

import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mobiquity.R
import com.mobiquity.base.BaseActivity
import com.mobiquity.databinding.ActivityProductDetailBinding
import com.mobiquity.productlist.ProductListViewModel
import javax.inject.Inject

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

class ProductDetailActivity:BaseActivity<ActivityProductDetailBinding,ProductDetailViewModel>(),ProductDetailNavigator {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.activity_product_detail
    override val mViewModel: ProductDetailViewModel
        get() = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(ProductDetailViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }
}
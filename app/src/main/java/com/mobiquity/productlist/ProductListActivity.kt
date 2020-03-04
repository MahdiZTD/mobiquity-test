package com.mobiquity.productlist

import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mobiquity.R
import com.mobiquity.base.BaseActivity
import com.mobiquity.databinding.ActivityProductListBinding
import com.mobiquity.datamodel.Product
import com.mobiquity.productdetail.ProductDetailActivity
import com.mobiquity.productlist.adpter.ProductListAdapter
import javax.inject.Inject

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

class ProductListActivity : BaseActivity<ActivityProductListBinding, ProductListViewModel>(),
    ProductListNavigator, ProductListAdapter.OnItemClicked {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter:ProductListAdapter

    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.activity_product_list
    override val mViewModel: ProductListViewModel
        get() = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(ProductListViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)

        adapter.clickListener = this
        viewDataBinding.rvCategories.adapter = adapter

        mViewModel.categoryLiveData.observe(this , Observer {
            if(it!=null){
                mViewModel.categories.clear()
                mViewModel.categories.addAll(it)
            }
        })

        mViewModel.getProducts()

    }

    override fun onItemClicked(product: Product) {
        val intent = Intent(this,ProductDetailActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)
    }
}

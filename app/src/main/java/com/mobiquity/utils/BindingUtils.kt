package com.mobiquity.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobiquity.R
import com.mobiquity.datamodel.CategoryModel
import com.mobiquity.datamodel.Product
import com.mobiquity.productlist.adpter.ProductListAdapter
import com.mobiquity.productlist.adpter.SubItemAdapter
import com.truetechteam.aba.infrustructure.network.ApiRepository

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
object BindingUtils {

    @JvmStatic
    @BindingAdapter("categoryAdapter")
    fun bindCategoryAdapter(recyclerView: RecyclerView?, categories: MutableList<CategoryModel>?) {
        if (categories != null) {
            val adapter = recyclerView?.adapter as ProductListAdapter?
            adapter?.clearItems()
            adapter?.addItems(categories)
        }
    }

    @JvmStatic
    @BindingAdapter("glideLoad")
    fun bindProductAdapter(imageView: ImageView?, imageUrl: String?) {
        if (imageView != null && imageUrl != null) {
            Glide.with(imageView.context)
                .load("${ApiRepository.END_POINT}$imageUrl")
                .placeholder(R.drawable.ic_error)
                .into(imageView)
        }
    }

}
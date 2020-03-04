package com.mobiquity.productdetail

import androidx.databinding.ObservableField
import com.mobiquity.base.BaseViewModel
import com.mobiquity.datamodel.Product

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class ProductDetailViewModel:BaseViewModel<ProductDetailNavigator>() {

    var productName=ObservableField<String>()
    var productPrice=ObservableField<String>()
    var productImage=ObservableField<String>()

    fun setProduct(product:Product?){
        if (product!=null) {
            productName.set(product.name)
            productPrice.set("${product.salePrice.amount} ${product.salePrice.currency}")
            productImage.set(product.url)
        }
    }

}
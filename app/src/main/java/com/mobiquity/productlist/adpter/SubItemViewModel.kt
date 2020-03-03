package com.mobiquity.productlist.adpter

import androidx.databinding.ObservableField
import com.mobiquity.datamodel.Product

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class SubItemViewModel(var product:Product) {
    var productName = ObservableField<String>(product.name)
    var productPrice = ObservableField<String>("${product.salePrice.amount} ${product.salePrice.currency}")
    var productImage = ObservableField<String>(product.url)
}
package com.mobiquity.productlist.adpter

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.mobiquity.datamodel.CategoryModel
import com.mobiquity.datamodel.Product

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class ProductItemViewModel(category: CategoryModel) {

    var categoryName = ObservableField<String>(category.name)
    var categoryDesc = ObservableField<String>(category.description)

}
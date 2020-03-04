package com.mobiquity.datamodel

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(val categoryId: String,
                   val description: String,
                   val id: String,
                   val name: String,
                   val salePrice: SalePrice,
                   val url: String):Parcelable
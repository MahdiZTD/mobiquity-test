package com.mobiquity.datamodel

data class CategoryModel(
    val description: String,
    val id: String,
    val name: String,
    val products: MutableList<Product>
)
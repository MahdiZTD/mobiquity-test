package com.mobiquity.productlist.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.base.BaseViewHolder
import com.mobiquity.databinding.ItemCategoryBinding
import com.mobiquity.datamodel.CategoryModel

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class ProductListAdapter(var categories:MutableList<CategoryModel>) : RecyclerView.Adapter<ProductListAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItems(categories: MutableList<CategoryModel>){
        this.categories.clear()
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }

    fun clearItems(){
        this.categories.clear()
        notifyDataSetChanged()
    }


    inner class CategoryViewHolder(var mBinding:ItemCategoryBinding):BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.vm = ProductItemViewModel(categories[position])
            mBinding.rvProducts.adapter = SubItemAdapter(categories[position].products)
            mBinding.executePendingBindings()
        }
    }
}
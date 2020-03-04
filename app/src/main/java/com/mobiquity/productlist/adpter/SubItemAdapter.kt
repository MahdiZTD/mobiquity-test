package com.mobiquity.productlist.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.base.BaseViewHolder
import com.mobiquity.databinding.ItemProductBinding
import com.mobiquity.datamodel.Product

/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */
class SubItemAdapter(var products: MutableList<Product>,var listener:ProductListAdapter.OnItemClicked?) :
    RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubItemViewHolder {
        return SubItemViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: SubItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class SubItemViewHolder(var mBinding: ItemProductBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mBinding.vm = SubItemViewModel(products[position],listener)
            mBinding.executePendingBindings()
        }
    }

}
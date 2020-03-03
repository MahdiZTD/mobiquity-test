package com.mobiquity.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Mahdi Zare Tahghigh Doost on 3/3/2020.
 * SnappQ
 * mahdiZTD@gmail.com
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}

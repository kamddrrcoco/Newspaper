package com.android.news.adapter


import android.widget.TextView
import com.android.news.R
import com.android.news.data.ImageData
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ListAdapter(layoutRes: Int = R.layout.item_list) :
    BaseQuickAdapter<ImageData, BaseViewHolder>(layoutRes) {
    override fun convert(holder: BaseViewHolder, item: ImageData) {
        holder.getView<TextView>(R.id.tv_text).text = item.title
        Glide.with(context)
            .load(item.image)
            .fitCenter()
            .into(holder.getView(R.id.iv_image))
    }
}
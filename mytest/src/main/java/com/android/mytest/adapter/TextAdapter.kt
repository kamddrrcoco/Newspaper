package com.android.mytest.adapter


import android.widget.TextView
import com.android.mytest.R
import com.android.mytest.data.ImageData
import com.android.mytest.data.TextData
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class TextAdapter(layoutRes: Int = R.layout.item_text) :
    BaseQuickAdapter<TextData, BaseViewHolder>(layoutRes) {
    override fun convert(holder: BaseViewHolder, item: TextData) {
        holder.getView<TextView>(R.id.tv_text_title).text = item.title
    }
}
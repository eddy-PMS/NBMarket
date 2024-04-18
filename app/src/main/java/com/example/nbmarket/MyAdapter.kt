package com.example.nbmarket

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.nbmarket.databinding.ActivityMainBinding
import com.example.nbmarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        holder.productImage.setImageResource(mItems[position].aImage)
        holder.product.text = mItems[position].aProduct
        holder.address.text = mItems[position].aAddress
        val priceComma = addCommas(mItems[position].aPrice.toInt())
        holder.price.text = "${priceComma}원"
        holder.chat.text = mItems[position].aChat
        holder.like.text = mItems[position].aLike
    }
    fun addCommas(number: Int): String {
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(number.toLong())
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val productImage = binding.productImageView
        val product = binding.productTextView
        val address = binding.addressTextView
        val price = binding.priceTextView
        val chat = binding.chatTextView
        val like = binding.likeTextView
    }
}
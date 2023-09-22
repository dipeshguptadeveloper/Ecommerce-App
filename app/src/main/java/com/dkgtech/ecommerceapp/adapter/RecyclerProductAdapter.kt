package com.dkgtech.ecommerceapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.ecommerceapp.ProductDetailActivity
import com.dkgtech.ecommerceapp.databinding.ProductRowBinding
import com.dkgtech.ecommerceapp.model.ProductModel
import com.squareup.picasso.Picasso

class RecyclerProductAdapter(val context: Context, val productList: ArrayList<ProductModel>) :
    RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProductRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ProductRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Picasso.get().load(productList[position].productImage).into(productImage)
            productTitle.text = productList[position].productTitle
            productPrice.append(productList[position].productPrice)

            productCardView.setOnClickListener {
                context.startActivity(
                    Intent(
                        context,
                        ProductDetailActivity::class.java
                    ).putExtra("pId", productList[position].pId)
                )
            }

        }

    }

}
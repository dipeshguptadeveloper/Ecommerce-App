package com.dkgtech.ecommerceapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.ecommerceapp.databinding.CategoryRowBinding
import com.dkgtech.ecommerceapp.model.CategoryModel

class RecyclerCategoryAdapter(val context: Context, val categoryList: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<RecyclerCategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: CategoryRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CategoryRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            catImage.setImageResource(categoryList[position].categoryImage)
            catTitle.text = categoryList[position].categoryTitle
        }
    }
}
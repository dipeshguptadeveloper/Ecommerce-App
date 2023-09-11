package com.dkgtech.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.dkgtech.ecommerceapp.adapter.RecyclerCategoryAdapter
import com.dkgtech.ecommerceapp.databinding.ActivityMainBinding
import com.dkgtech.ecommerceapp.model.CategoryModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val imageList = ArrayList<SlideModel>()
            imageList.add(SlideModel(R.drawable.banner_1))
            imageList.add(SlideModel(R.drawable.banner_2))
            imageList.add(SlideModel(R.drawable.banner_3))

            val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
            imageSlider.setImageList(imageList)
            imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)

            rcViewCategory.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            val categoryList = ArrayList<CategoryModel>()
            categoryList.add(CategoryModel("Shoes", R.drawable.cat_shoes))
            categoryList.add(CategoryModel("Beauty", R.drawable.cat_beauty))
            categoryList.add(CategoryModel("Women's\nFashion", R.drawable.cat_womens))
            categoryList.add(CategoryModel("Jewellery", R.drawable.cat_jewellery))
            categoryList.add(CategoryModel("Men's\nFashion", R.drawable.cat_men))
            rcViewCategory.adapter = RecyclerCategoryAdapter(this@MainActivity, categoryList)

        }
    }
}
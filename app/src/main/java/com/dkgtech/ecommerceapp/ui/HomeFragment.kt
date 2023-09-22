package com.dkgtech.ecommerceapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.dkgtech.ecommerceapp.R
import com.dkgtech.ecommerceapp.adapter.RecyclerCategoryAdapter
import com.dkgtech.ecommerceapp.adapter.RecyclerProductAdapter
import com.dkgtech.ecommerceapp.databinding.FragmentHomeBinding
import com.dkgtech.ecommerceapp.model.BannerModel
import com.dkgtech.ecommerceapp.model.CategoryModel
import com.dkgtech.ecommerceapp.model.ProductModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val db = Firebase.firestore


//        banner
        val imageList = ArrayList<SlideModel>()
        val ref = db.collection("banner").get().addOnSuccessListener {
            for (document in it.documents) {
                val bannerModel = document.toObject(BannerModel::class.java)!!
                imageList.add(
                    SlideModel(
                        bannerModel.bannerImage,
                        bannerModel.name,
                        ScaleTypes.FIT
                    )
                )
            }
            binding.imageSlider.setImageList(imageList)

        }

//        categories
        val categoryModel = ArrayList<CategoryModel>()
        db.collection("categories").get().addOnSuccessListener {
            for (document in it.documents) {
                categoryModel.add(document.toObject(CategoryModel::class.java)!!)
            }

            binding.rcViewCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcViewCategory.adapter =
                RecyclerCategoryAdapter(requireContext(), categoryModel)

        }

//        products
        val productModel = ArrayList<ProductModel>()
        db.collection("products").get().addOnSuccessListener {
            for (document in it.documents) {
                productModel.add(document.toObject(ProductModel::class.java)!!)
            }
            binding.rcViewProducts.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rcViewProducts.adapter = RecyclerProductAdapter(requireContext(), productModel)
        }



        return binding.root
    }
}
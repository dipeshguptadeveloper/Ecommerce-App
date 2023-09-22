package com.dkgtech.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dkgtech.ecommerceapp.databinding.ActivityProductDetailBinding
import com.dkgtech.ecommerceapp.model.ProductModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso


class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private val db = Firebase.firestore
    private lateinit var productModel: ProductModel
    var itemCount = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)

        val pId = intent.getStringExtra("pId")

        if (pId!!.isNotBlank()) {
            db.collection("products").whereEqualTo("pId", pId).get().addOnSuccessListener {
                if (it.size() == 1) {
                    productModel = it.documents[0].toObject(ProductModel::class.java)!!
                    Picasso.get().load(productModel.productImage).into(binding.pdImgProductImage)
                    binding.pdTxtProductName.text = productModel.productTitle
                    binding.pdTxtProductPrice.text = productModel.productPrice
                    binding.pdTxtProductDescription.text = productModel.productDescription
                }
            }
        }


        binding.pdImgBackButton.setOnClickListener {
            super.onBackPressed()
        }

        binding.pdImgAddButton.setOnClickListener {
            itemCount++
            binding.pdTxtQuantity.text = itemCount.toString()
        }
        binding.pdImgMinusButton.setOnClickListener {
            if (itemCount > 1) {
                itemCount--
                binding.pdTxtQuantity.text = itemCount.toString()
            }
        }

        // Info

        // Top Navigation Related views
        binding.pdImgBackButton
        binding.pdImgShareButton
        binding.pdImgLikeButton

        // Product Related views
        binding.pdImgProductImage
        binding.pdTxtProductName
        binding.pdTxtProductPrice

        // Color Related views
        binding.pdViewProductColor1
        binding.pdViewProductColor2
        binding.pdViewProductColor3







        setContentView(binding.root)
    }
}
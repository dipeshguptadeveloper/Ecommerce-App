package com.dkgtech.ecommerceapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dkgtech.ecommerceapp.databinding.ActivityMainBinding
import com.dkgtech.ecommerceapp.ui.CartFragment
import com.dkgtech.ecommerceapp.ui.FavouriteFragment
import com.dkgtech.ecommerceapp.ui.HomeFragment
import com.dkgtech.ecommerceapp.ui.MenuFragment
import com.dkgtech.ecommerceapp.ui.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            fm = supportFragmentManager

            loadFragment(HomeFragment(), true)
            bnView.selectedItemId = R.id.nav_home

            bnView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_menu -> loadFragment(MenuFragment(), false)
                    R.id.nav_home -> loadFragment(HomeFragment(), false)
                    R.id.nav_fav -> loadFragment(FavouriteFragment(), false)
                    R.id.nav_cart -> loadFragment(CartFragment(), false)
                    R.id.nav_profile -> loadFragment(ProfileFragment(), false)
                }
                true
            }


        }
    }

    private fun loadFragment(frag: Fragment, flag: Boolean) {
        val ft = fm.beginTransaction()
        if (flag) {
            ft.add(R.id.container, frag)
        } else {
            ft.replace(R.id.container, frag)
        }
        ft.commit()
    }
}
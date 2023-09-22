package com.dkgtech.ecommerceapp

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            loadFragment(HomeFragment())

            bnView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_menu -> loadFragment(MenuFragment())
                    R.id.nav_home -> loadFragment(HomeFragment())
                    R.id.nav_fav -> loadFragment(FavouriteFragment())
                    R.id.nav_cart -> loadFragment(CartFragment())
                    R.id.nav_profile -> loadFragment(ProfileFragment())
                }
                true
            }


        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Replace the fragment_container with the new fragment
        transaction.replace(R.id.container, fragment)
        // Commit the transaction
        transaction.attach(HomeFragment())
        transaction.commit()
    }
}